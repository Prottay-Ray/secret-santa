package com.secretsanta.userauthenticationservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class UserDoesNotExistException extends RuntimeException{

    public UserDoesNotExistException(String message) {
        super(message);
    }
}
