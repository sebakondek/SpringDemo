package org.demo.springDemo.exception;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@EqualsAndHashCode(callSuper = true)
public abstract class SpringDemoGenericException extends RuntimeException {
    private final String message;
    private final HttpStatus httpStatus;

    public SpringDemoGenericException(String message, HttpStatus httpStatus) {
        super(message);
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public SpringDemoGenericException(String message, HttpStatus httpStatus, Throwable ex) {
        super(message, ex);
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
