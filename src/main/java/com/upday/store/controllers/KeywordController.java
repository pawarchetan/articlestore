package com.upday.store.controllers;

import com.upday.store.domains.Article;
import com.upday.store.services.KeywordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/keywords")
public class KeywordController {
    private final KeywordService keywordService;

    @Autowired
    public KeywordController(KeywordService keywordService) {
        this.keywordService = keywordService;
    }

    @GetMapping(value = "/{word}", produces = "application/json")
    public ResponseEntity<Set<Article>> findAllArticlesForKeyword(@PathVariable("word") String word){
        return new ResponseEntity<>(keywordService.findAllArticlesForKeyword(word), HttpStatus.OK);
    }
}
