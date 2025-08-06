package com.learning.ecommerce_spring.exception;

public class CustomException extends RuntimeException {
    public CustomException(String message) {
        super(message);
    }
}
