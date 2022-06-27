package com.axyya.newapplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "page not found")
public class ServerNotFoundException extends RuntimeException{
    String message;
    public ServerNotFoundException(String message) {
        super(message);
    }
}
