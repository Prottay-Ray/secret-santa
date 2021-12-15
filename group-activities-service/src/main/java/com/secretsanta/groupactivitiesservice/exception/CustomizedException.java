package com.secretsanta.groupactivitiesservice.exception;

import com.secretsanta.groupactivitiesservice.dto.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class CustomizedException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserDoesNotExistException.class)
    public final ResponseEntity<Object> handleAuthenticationException(Exception e, WebRequest request) {
        ExceptionDTO ex = new ExceptionDTO(new Date(), e.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(ex, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(GroupNameUnavailableException.class)
    public final ResponseEntity<Object> handleGroupNameException(Exception e, WebRequest request) {
        ExceptionDTO ex = new ExceptionDTO(new Date(), e.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(ex, HttpStatus.IM_USED);
    }

    @ExceptionHandler(GroupNotFoundException.class)
    public final ResponseEntity<Object> handleGroupNotFoundException(Exception e, WebRequest request) {
        ExceptionDTO ex = new ExceptionDTO(new Date(), e.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(ex, HttpStatus.BAD_REQUEST);
    }

}
