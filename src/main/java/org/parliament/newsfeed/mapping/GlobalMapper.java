package org.parliament.newsfeed.mapping;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.parliament.newsfeed.dto.ArticleDTO;
import org.parliament.newsfeed.model.Article;

import java.util.List;

@Mapper
public interface GlobalMapper {

    @Mapping(target = "date", dateFormat = "dd/MM/yyyy")
    ArticleDTO articleToArticleDTO(Article in);

    @Mapping(target = "date", dateFormat = "dd/MM/yyyy")
    Article articleDTOToArticle(ArticleDTO request);

    List<ArticleDTO> articlesToArticlesDTO(List<Article> in);
}
