package org.parliament.newsfeed.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.parliament.newsfeed.util.Constants;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Schema(name = "Article", description = "The article entity")
public class ArticleDTO {

    @Schema(description = "The article identifier", example = "63df8b8e591e9532df4c8449")
    private String id;

    @Schema(description = "The article category", example = "ΡΕΠΟΡΤΑΖ")
    private String category;

    @Schema(description = "The article headline", example = "«Ναι» από τους φορείς στη θέσπιση παροχής Ανακουφιστικής Φροντίδας")
    private String headline;

    @Schema(description = "The article subhead", example = "Αμφιβολίες για τα χρονοδιαγράμματα διατύπωσαν βουλευτές της αντιπολίτευσης")
    private String subhead;

    @Schema(description = "The introductory paragraph containing the article context", example = Constants.intoContent)
    private String introduction;

    @Schema(description = "The magazine name", defaultValue = "Επί του... περιστυλίου!", example = "Επί του... περιστυλίου!")
    private String magazine = "Επί του... περιστυλίου!";

    @Schema(description = "The article author", example = "ΓΙΑΝΝΗΣ ΦΩΤΟΥΛΑΣ")
    private String author;

    @Schema(description = "The article publication", example = "ΤΕΥΧΟΣ_055")
    private String publication;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Schema(description = "The publication date", example = "22/12/2022")
    private String date;

    @Schema(description = "The media url of the corresponding parliamentary session", example = "https://www.hellenicparliament.gr/userfiles/media/synedriaseis/olomeleia-20220209.mp4", format = "uri")
    private String meeting;

    @Schema(description = "The article content", example = Constants.exampleContent)
    private String content;


}
