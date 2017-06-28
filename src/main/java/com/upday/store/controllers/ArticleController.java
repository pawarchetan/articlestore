package com.upday.store.controllers;

import com.upday.store.domains.Article;
import com.upday.store.domains.dto.ArticleDTO;
import com.upday.store.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {
    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Article> createArticle(@RequestBody @Valid ArticleDTO articleDTO){
        return new ResponseEntity<>(articleService.create(articleDTO), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Article> getArticleById(@PathVariable("id") String id){
        return new ResponseEntity<>(articleService.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/date", produces = "application/json")
    public ResponseEntity<List<Article>> getArticlesByDateRange(@RequestParam String dateFrom, @RequestParam String dateTo){
        return new ResponseEntity<>(articleService.findArticlesByDateRange(dateFrom, dateTo), HttpStatus.OK);
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<Iterable<Article>> getAllArticles(){
        return new ResponseEntity<>(articleService.findAll(), HttpStatus.OK);
    }

    @PutMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Article> editArticle(@RequestBody @Valid ArticleDTO articleDTO){
        return new ResponseEntity<>(articleService.edit(articleDTO), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteArticle(@PathVariable("id") String id){
        articleService.deleteById(id);
    }
}
