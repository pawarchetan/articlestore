package com.upday.store.exceptions;

public class AuthorNotFoundException extends IllegalArgumentException {
    private String message = "";

    public AuthorNotFoundException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
