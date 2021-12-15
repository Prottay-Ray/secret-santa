package com.secretsanta.groupactivitiesservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.IM_USED)
public class GroupNameUnavailableException extends RuntimeException {
    public GroupNameUnavailableException(String message) {
        super(message);
    }
}
