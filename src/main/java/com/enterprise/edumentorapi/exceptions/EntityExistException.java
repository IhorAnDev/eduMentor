package com.enterprise.edumentorapi.exceptions;

public class EntityExistException extends RuntimeException {
    public EntityExistException(String message) {
        super(message);
    }
}