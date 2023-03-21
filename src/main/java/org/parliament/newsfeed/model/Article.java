package org.parliament.newsfeed.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Document(value = "articles")
public class Article {

    @Id
    private String id;
    private String category;
    private String headline;
    private String subhead;
    private String introduction;
    private String magazine;
    private String author;
    @Indexed
    private String publication;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date date;
    private String meeting;
    @Indexed(unique = true)
    private String content;

}
