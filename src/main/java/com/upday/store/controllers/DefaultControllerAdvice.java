package com.upday.store.controllers;

import com.upday.store.exceptions.ArticleNotFoundException;
import com.upday.store.exceptions.ArticleStoreError;
import com.upday.store.exceptions.AuthorNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@ControllerAdvice
public class DefaultControllerAdvice {
    @ResponseStatus(NO_CONTENT)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public void handleMethodArgumentNotValidException() {
    }

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(ArticleNotFoundException.class)
    public ResponseEntity<ArticleStoreError> handleArticleNotFoundException() {
        ArticleStoreError error = new ArticleStoreError();
        error.setStatusCode(NOT_FOUND.value());
        error.setMessage("Article not found");
        return new ResponseEntity<>(error, NOT_FOUND);
    }

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(AuthorNotFoundException.class)
    public ResponseEntity<ArticleStoreError> handleAuthorNotFoundException() {
        ArticleStoreError error = new ArticleStoreError();
        error.setStatusCode(NOT_FOUND.value());
        error.setMessage("Author not found");
        return new ResponseEntity<>(error, NOT_FOUND);
    }
}
