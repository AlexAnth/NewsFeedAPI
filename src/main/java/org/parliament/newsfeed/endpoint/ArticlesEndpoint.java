package org.parliament.newsfeed.endpoint;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.parliament.newsfeed.dto.ArticleDTO;
import org.parliament.newsfeed.exception.AuthorNotFoundException;
import org.parliament.newsfeed.exception.CategoryNotFoundException;
import org.parliament.newsfeed.exception.PublicationNotFoundException;
import org.parliament.newsfeed.model.records.Author;
import org.parliament.newsfeed.model.records.Category;
import org.parliament.newsfeed.model.records.Publication;
import org.parliament.newsfeed.service.ArticlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/articles")
public class ArticlesEndpoint {

    @Autowired
    private ArticlesService articlesService;

    @GetMapping(value = "/{id}")
    @Operation(summary = "Retrieve article based on unique identifier",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Article found", content = @Content(schema = @Schema(implementation = ArticleDTO.class))),
                    @ApiResponse(responseCode = "404", description = "Article not found", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)},
            tags = {"Parliamentary Articles"})
    public Mono<ArticleDTO> getArticle(@PathVariable @Parameter(description = "The unique article id") String id) {
        return articlesService.getArticle(id);
    }

    @GetMapping(value = "/publication/{id}")
    @Operation(summary = "Retrieve a stream of articles based on publication identifier",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Articles found", content = @Content(schema = @Schema(implementation = ArticleDTO.class))),
                    @ApiResponse(responseCode = "404", description = "Articles with specified publication id were not found"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")},
            tags = {"Parliamentary Articles"})
    public Flux<ArticleDTO> getArticlesByPublication(@Parameter(name = "id", description = "The publication id", example = "ΤΕΥΧΟΣ_055") @PathVariable String id) {
        return articlesService.getArticlesByPublication(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Retrieve article based on unique identifier",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Article created", content = @Content(schema = @Schema(implementation = ArticleDTO.class))),
                    @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)},
            tags = {"Parliamentary Articles"})
    public Mono<ArticleDTO> createArticle(@RequestBody ArticleDTO request) {
        return articlesService.createArticle(request);
    }

    @GetMapping(value = "/publications")
    @Operation(summary = "Retrieve a stream of all the publications available",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Publications were found"),
                    @ApiResponse(responseCode = "404", description = "Publications were not found", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)},
            tags = {"Parliamentary Articles"})
    public Flux<Publication> getAllPublications() {
        return articlesService.getAllPublications()
                .switchIfEmpty(Flux.error(new PublicationNotFoundException("No publications were found")));
    }

    @GetMapping(value = "/authors")
    @Operation(summary = "Retrieve a stream of all the authors of available articles",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Authors were found"),
                    @ApiResponse(responseCode = "404", description = "Authors were not found", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)},
            tags = {"Parliamentary Articles"})
    public Flux<Author> getAllAuthors() {
        return articlesService.getAllAuthors()
                .switchIfEmpty(Flux.error(new AuthorNotFoundException("No authors were found")));
    }

    @GetMapping(value = "/categories")
    @Operation(summary = "Retrieve a stream of all the available article categories",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Categories were found"),
                    @ApiResponse(responseCode = "404", description = "Categories were not found", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)},
            tags = {"Parliamentary Articles"})
    public Flux<Category> getAllCategories() {
        return articlesService.getAllCategories()
                .switchIfEmpty(Flux.error(new CategoryNotFoundException("No authors were found")));
    }

}
