package com.upday.store.exceptions;

public class KeywordNotFoundException extends IllegalArgumentException {
    private String message = "";

    public KeywordNotFoundException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
