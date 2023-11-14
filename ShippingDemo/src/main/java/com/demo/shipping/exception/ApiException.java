package com.demo.shipping.exception;

public class ApiException extends RuntimeException {
    public ApiException(String message) {
        super(message);
    }
}
