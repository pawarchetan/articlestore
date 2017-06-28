package com.upday.store.services;

import com.upday.store.domains.Article;

import java.util.Set;

public interface AuthorService {
    Set<Article> findAllArticlesWrittenByAuthor(String id);

    Set<Article> findAllArticlesWrittenByAuthorName(String name);
}
