package org.parliament.newsfeed.service;

import org.mapstruct.factory.Mappers;
import org.parliament.newsfeed.dto.ArticleDTO;
import org.parliament.newsfeed.exception.ArticleNotFoundException;
import org.parliament.newsfeed.mapping.GlobalMapper;
import org.parliament.newsfeed.model.Article;
import org.parliament.newsfeed.model.records.Author;
import org.parliament.newsfeed.model.records.Category;
import org.parliament.newsfeed.model.records.Publication;
import org.parliament.newsfeed.repository.ArticlesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ArticlesService {

    @Autowired
    private ArticlesRepository articlesRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    GlobalMapper globalMapper = Mappers.getMapper(GlobalMapper.class);

    public Mono<ArticleDTO> getArticle(String id) {
        return articlesRepository.findById(id)
                .map(globalMapper::articleToArticleDTO)
                .switchIfEmpty(Mono.error(new ArticleNotFoundException("Article with id " + id + " was not found")));
    }

    public Mono<ArticleDTO> createArticle(ArticleDTO request) {
        return articlesRepository
                .save(globalMapper.articleDTOToArticle(request))
                .onErrorResume(e -> {
                    if (e instanceof DuplicateKeyException)
                        return articlesRepository.findByContent(request.getContent());
                    else
                        return Mono.error(e);
                })
                .map(globalMapper::articleToArticleDTO);

    }

    public Flux<ArticleDTO> getArticlesByPublication(String publication) {
        return articlesRepository.findByPublication(publication)
                .map(globalMapper::articleToArticleDTO)
                .switchIfEmpty(Mono.error(new ArticleNotFoundException("Articles with publication id " + publication + " were not found")));
    }

    public Flux<Publication> getAllPublications() {
        return Flux.fromIterable(mongoTemplate
                .findDistinct("publication", Article.class, String.class)
                .stream()
                .filter(Objects::nonNull)
                .map(Publication::new)
                .collect(Collectors.toList()));

    }

    public Flux<Category> getAllCategories() {
        return Flux.fromIterable(mongoTemplate
                .findDistinct("category", Article.class, String.class)
                .stream()
                .filter(Objects::nonNull)
                .map(Category::new)
                .collect(Collectors.toList()));
    }

    public Flux<Author> getAllAuthors() {
        return Flux.fromIterable(mongoTemplate
                .findDistinct("author", Article.class, String.class)
                .stream()
                .filter(Objects::nonNull)
                .map(Author::new)
                .collect(Collectors.toList()));
    }


}
