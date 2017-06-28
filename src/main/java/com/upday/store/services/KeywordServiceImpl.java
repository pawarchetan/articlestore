package com.upday.store.services;

import com.upday.store.domains.Article;
import com.upday.store.domains.Keyword;
import com.upday.store.exceptions.KeywordNotFoundException;
import com.upday.store.repository.KeywordRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class KeywordServiceImpl implements KeywordService {
    private final KeywordRepository keywordRepository;

    public KeywordServiceImpl(KeywordRepository keywordRepository) {
        this.keywordRepository = keywordRepository;
    }

    @Override
    public Iterable<Keyword> findAll() {
        return keywordRepository.findAll();
    }

    @Override
    public Set<Article> findAllArticlesForKeyword(String word) {
        Keyword keyword = keywordRepository.findByWord(word);
        if (keyword == null) {
            throw createKeywordNotFoundException(new Exception("Keyword Not Found."));
        }
        return keyword.getArticles();
    }

    private KeywordNotFoundException createKeywordNotFoundException(Exception e) {
        String errorMessage = e.getLocalizedMessage();
        return new KeywordNotFoundException(errorMessage);
    }
}
