package com.upday.store.exceptions;

public class ArticleNotFoundException extends IllegalArgumentException {
    private String message = "";

    public ArticleNotFoundException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
