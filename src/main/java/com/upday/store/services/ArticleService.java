package com.upday.store.services;

import com.upday.store.domains.Article;
import com.upday.store.domains.dto.ArticleDTO;

import java.util.List;

public interface ArticleService {
    Iterable<Article> findAll();

    Article findById(String id);

    Article create(ArticleDTO articleDTO);

    Article edit(ArticleDTO articleDTO);

    void deleteById(String id);

    List<Article> findArticlesByDateRange(String dateFrom, String dateTo);
}
