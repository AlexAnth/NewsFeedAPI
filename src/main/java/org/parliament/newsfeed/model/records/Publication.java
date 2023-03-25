package org.parliament.newsfeed.model.records;

import io.swagger.v3.oas.annotations.media.Schema;

public record Publication(@Schema(description = "The publication name", example = "ΤΕΥΧΟΣ_054") String publication) {}
