package com.upday.store.util;

import com.upday.store.domains.Article;
import com.upday.store.domains.Author;
import com.upday.store.domains.Keyword;
import com.upday.store.domains.dto.ArticleDTO;

import java.util.Set;

public final class ArticleMapper {
    public static Article mapArticleDTOToArticleEntity(ArticleDTO articleDTO, Article article, Iterable<Keyword> keywordIterable) {
        if (article == null) {
            article = new Article();
        }
        article.setHeader(articleDTO.getHeader());
        article.setShortDescription(articleDTO.getShortDescription());
        article.setText(articleDTO.getText());
        article.setPublishDate(articleDTO.getPublishDate());

        Author author = AuthorMapper.mapAuthorDTOToAuthorEntity(articleDTO.getAuthor());
        article.setAuthor(author);

        Set<Keyword> keywords = KeywordMapper.mapKeywordDTOsToPersistableEntities(articleDTO, keywordIterable);
        article.setKeywords(keywords);

        return article;
    }
}
