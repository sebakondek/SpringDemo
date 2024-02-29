package org.demo.springDemo.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends SpringDemoGenericException {
    public BadRequestException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
