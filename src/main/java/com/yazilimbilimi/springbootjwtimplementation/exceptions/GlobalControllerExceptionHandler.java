package com.yazilimbilimi.springbootjwtimplementation.exceptions;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.context.annotation.PropertySource;
import org.springframework.dao.DataIntegrityViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.UserDetailsManagerConfigurer;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalControllerExceptionHandler {
    Logger logger = LoggerFactory.getLogger(GlobalControllerExceptionHandler.class);

    // Exception Handler Here

    // Exception Handler Here

    // Exception Handler Here

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> handleDataIntegrityException(Exception ex){
        ApiError apiError = new ApiError.
                Builder()
                .withMessage("Validation Error")
                .withHttpStatus(HttpStatus.BAD_REQUEST)
                .withCreatedAt()
                .build();

        return new ResponseEntity<>(apiError,apiError.getHttpStatus());

    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGenericException(Exception exception){
        ApiError apiError = new ApiError.
                Builder()
                .withMessage("Some Error Occurred")
                .withHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                .withCreatedAt()
                .build();

        return new ResponseEntity<>(apiError,apiError.getHttpStatus());

    }
}
