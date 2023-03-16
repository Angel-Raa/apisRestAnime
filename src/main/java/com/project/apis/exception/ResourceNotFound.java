package com.project.apis.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFound extends RuntimeException{
    public String message;
    public String field;

    public ResourceNotFound(String message, String field) {
        this.message = message;
        this.field = field;
    }
}
