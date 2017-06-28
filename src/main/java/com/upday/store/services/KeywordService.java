package com.upday.store.services;

import com.upday.store.domains.Article;
import com.upday.store.domains.Keyword;

import java.util.Set;

public interface KeywordService {
    Iterable<Keyword> findAll();

    Set<Article> findAllArticlesForKeyword(String word);
}
