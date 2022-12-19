package com.ToyProject.eun.exception;

public class CustomInternalServerErrorException extends RuntimeException {
    public CustomInternalServerErrorException(String message) {
        super(message);
    }
}
