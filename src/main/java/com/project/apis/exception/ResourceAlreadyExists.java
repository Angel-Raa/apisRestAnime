package com.project.apis.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ResourceAlreadyExists extends RuntimeException{
    private String message;
    private String resource;

    public ResourceAlreadyExists(String message, String resource) {
        this.message = message;
        this.resource = resource;
    }
}
