package com.secretsanta.userauthenticationservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserCreationFailedException extends RuntimeException{

    public UserCreationFailedException(String message) {
        super(message);
    }
}
