package org.parliament.newsfeed.model.records;

import io.swagger.v3.oas.annotations.media.Schema;

public record Category(@Schema(description = "The category name", example = "ΡΕΠΟΡΤΑΖ") String category) {}
