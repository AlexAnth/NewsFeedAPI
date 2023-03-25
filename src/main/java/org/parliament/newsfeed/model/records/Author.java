package org.parliament.newsfeed.model.records;

import io.swagger.v3.oas.annotations.media.Schema;

public record Author(@Schema(description = "The author name", example = "ΓΙΑΝΝΗΣ ΦΩΤΟΥΛΑΣ") String author) {}