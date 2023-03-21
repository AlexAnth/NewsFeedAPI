package org.parliament.newsfeed.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PublicationNotFoundException extends Exception {

    public PublicationNotFoundException(String message) {
        super(message);
    }
}
