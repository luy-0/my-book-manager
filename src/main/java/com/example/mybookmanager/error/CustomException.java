package com.example.mybookmanager.error;

import org.springframework.http.HttpStatus;

public class CustomException extends Exception {
    private String message;
    private HttpStatus httpStatus;

    public CustomException(HttpStatus httpStatus, String message) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
