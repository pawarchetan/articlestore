package com.upday.store.controllers;

import com.upday.store.domains.Article;
import com.upday.store.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {
    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Set<Article>> findAllArticlesWrittenByAuthor(@PathVariable("id") String id){
        return new ResponseEntity<>(authorService.findAllArticlesWrittenByAuthor(id), HttpStatus.OK);
    }

    @GetMapping(value = "/name/{name}", produces = "application/json")
    public ResponseEntity<Set<Article>> findAllArticlesWrittenByAuthorName(@PathVariable("name") String name){
        return new ResponseEntity<>(authorService.findAllArticlesWrittenByAuthorName(name), HttpStatus.OK);
    }
}
