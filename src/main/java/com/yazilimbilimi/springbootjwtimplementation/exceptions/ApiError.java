package com.yazilimbilimi.springbootjwtimplementation.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;
import java.util.TimeZone;

@Data
public class ApiError {
    private HttpStatus httpStatus;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime createdAt;
    private String message;

    public ApiError(Builder builder) {
        this.httpStatus = builder.httpStatus;
        this.createdAt = builder.createdAt;
        this.message = builder.message;
    }

     static class Builder {
        private HttpStatus httpStatus;
        private String message;
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
        private LocalDateTime createdAt;

        public Builder(){}

        public Builder withHttpStatus(HttpStatus httpStatus) {
            this.httpStatus = httpStatus;
            return this;
        }
        public Builder withCreatedAt() {
            this.createdAt = LocalDateTime.now();
            return this;
        }
        public Builder withMessage(String message) {
            this.message = message;
            return this;
        }

        public ApiError build(){
            return new ApiError(this);
        }

    }

}