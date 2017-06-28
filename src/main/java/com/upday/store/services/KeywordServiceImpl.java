package com.upday.store.services;

import com.upday.store.domains.Article;
import com.upday.store.domains.Keyword;
import com.upday.store.exceptions.KeywordNotFoundException;
import com.upday.store.repository.KeywordRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Log4j2
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
        log.error("Keyword with tag/word: " + word + " not Found.");
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
