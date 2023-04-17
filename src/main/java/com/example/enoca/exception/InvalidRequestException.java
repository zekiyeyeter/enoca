package com.example.enoca.exception;

import org.springframework.http.HttpStatus;

public class InvalidRequestException extends ApplicationException {

    public InvalidRequestException(String message) {
        super(-1, message, HttpStatus.CONFLICT);

    }
}
