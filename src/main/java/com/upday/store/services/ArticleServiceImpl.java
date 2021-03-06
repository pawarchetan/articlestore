package com.upday.store.services;

import com.upday.store.domains.Article;
import com.upday.store.domains.Keyword;
import com.upday.store.domains.dto.ArticleDTO;
import com.upday.store.exceptions.ArticleNotFoundException;
import com.upday.store.repository.ArticleRepository;
import com.upday.store.util.ArticleMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Service
@Log4j2
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;
    private final KeywordService keywordService;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository, KeywordService keywordService) {
        this.articleRepository = articleRepository;
        this.keywordService = keywordService;
    }

    @Override
    public Iterable<Article> findAll() {
        log.info("Finding All Articles");
        return articleRepository.findAll();
    }

    @Override
    public Article findById(String id) {
        Article article = articleRepository.findOne(id);
        if (article == null) {
            log.error("Article with Id: " + id + " not Found.");
            throw createArticleNotFoundException(new Exception("Article Not Found"));
        }
        return articleRepository.findOne(id);
    }

    @Override
    public Article create(ArticleDTO articleDTO) {
        Iterable<Keyword> keywordIterable = keywordService.findAll();
        Article article = ArticleMapper.mapArticleDTOToArticleEntity(articleDTO, null, keywordIterable);
        return articleRepository.save(article);
    }

    @Override
    public Article edit(ArticleDTO articleDTO) {
        Iterable<Keyword> keywordIterable = keywordService.findAll();
        Article persistedArticle = findById(articleDTO.getId());
        persistedArticle = ArticleMapper.mapArticleDTOToArticleEntity(articleDTO, persistedArticle, keywordIterable);
        return articleRepository.save(persistedArticle);
    }

    @Override
    public void deleteById(String id) {
        articleRepository.delete(id);
    }

    @Override
    public List<Article> findArticlesPublishedWithinDateRange(String dateFrom, String dateTo) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Date dateFromDte = java.sql.Date.valueOf(LocalDate.parse(dateFrom, formatter));
        Date dateToDte = java.sql.Date.valueOf(LocalDate.parse(dateTo, formatter));
        return articleRepository.findArticlesByDateRange(dateFromDte, dateToDte);
    }

    private ArticleNotFoundException createArticleNotFoundException(Exception e) {
        String errorMessage = e.getLocalizedMessage();
        return new ArticleNotFoundException(errorMessage);
    }
}
