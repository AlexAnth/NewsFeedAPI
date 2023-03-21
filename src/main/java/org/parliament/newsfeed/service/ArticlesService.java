package org.parliament.newsfeed.service;

import io.swagger.v3.oas.annotations.media.Schema;
import org.mapstruct.factory.Mappers;
import org.parliament.newsfeed.dto.ArticleDTO;
import org.parliament.newsfeed.exception.ArticleNotFoundException;
import org.parliament.newsfeed.mapping.GlobalMapper;
import org.parliament.newsfeed.model.Article;
import org.parliament.newsfeed.repository.ArticlesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ArticlesService {

    @Autowired
    private ArticlesRepository articlesRepository;

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
        return articlesRepository.findAll()
                .filter(article -> article.getPublication() != null)
                .map(Article::getPublication)
                .map(Publication::new)
                .distinct();
    }

    public Flux<Category> getAllCategories() {
        return articlesRepository.findAll()
                .filter(article -> article.getCategory() != null)
                .map(Article::getCategory)
                .map(Category::new)
                .distinct();
    }

    public Flux<Author> getAllAuthors() {
        return articlesRepository.findAll()
                .filter(article -> article.getAuthor() != null)
                .map(Article::getAuthor)
                .map(Author::new)
                .distinct();
    }

    public record Publication(@Schema(description = "The publication name", example = "ΤΕΥΧΟΣ_054") String name) {
    }

    public record Author(@Schema(description = "The author name", example = "ΓΙΑΝΝΗΣ ΦΩΤΟΥΛΑΣ") String name) {
    }

    public record Category(@Schema(description = "The category name", example = "ΡΕΠΟΡΤΑΖ") String name) {
    }

}
