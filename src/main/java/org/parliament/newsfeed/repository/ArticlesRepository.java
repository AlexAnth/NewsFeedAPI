package org.parliament.newsfeed.repository;

import org.parliament.newsfeed.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseStatus;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.List;

@Repository
public interface ArticlesRepository extends ReactiveMongoRepository<Article, String> {

    Flux<Article> findByPublication(String publication);

    Mono<Article> findByContent(String content);

    Flux<Article> findByCategory(String category);

    Flux<Article> findByAuthor(String author);

    Flux<Article> findByDate(Date from, Date to);

    Flux<Article> findAll();

}
