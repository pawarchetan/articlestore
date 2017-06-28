package com.upday.store.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.upday.store.domains.Article;
import com.upday.store.domains.Author;
import com.upday.store.domains.Keyword;
import com.upday.store.domains.dto.ArticleDTO;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

final class TestDataBuilder {

    static Set<Article> getArticles() {
        Set<Article> articles = new HashSet<>();
        articles.add(getTestArticleOne());
        articles.add(getTestArticleTwo());
        return articles;
    }

    static Article getTestArticleOne() {
        Set<Keyword> keywords = new HashSet<>();
        keywords.add(getJavaKeyword());

        Article article = new Article();
        article.setId("test_article_id_1");
        article.setHeader("test_Header_1");
        article.setShortDescription("Sample_HTML_Article");
        article.setText("<ul><li>line 1</li><li>line 2</li><p>");
        article.setAuthor(getTestAuthorOne());
        article.setKeywords(keywords);
        return article;
    }

    static Article getTestArticleTwo() {
        Set<Keyword> keywords = new HashSet<>();
        keywords.add(getPhpKeyword());

        Article article2 = new Article();
        article2.setId("test_article_id_2");
        article2.setHeader("test_Header_2");
        article2.setShortDescription("Sample_HTML_Article_2");
        article2.setText("<ul><li>line 1</li><li>line 2</li><p></p>");
        article2.setAuthor(getTestAuthorTwo());
        article2.setKeywords(keywords);
        return article2;
    }

    static String convertObjectToJsonBytes(Object object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }

    private static Keyword getJavaKeyword() {
        Keyword keyword = new Keyword();
        keyword.setId("test_keyword_id_1");
        keyword.setWord("java");
        return keyword;
    }

    private static Keyword getPhpKeyword() {
        Keyword keyword = new Keyword();
        keyword.setId("test_keyword_id_2");
        keyword.setWord("php");
        return keyword;
    }

    private static Author getTestAuthorOne() {
        Author author = new Author();
        author.setId("test_author_id_1");
        author.setName("test_author_name_1");
        return author;
    }

    private static Author getTestAuthorTwo() {
        Author author = new Author();
        author.setId("test_author_id_2");
        author.setName("test_author_name_2");
        return author;
    }

    static ArticleDTO getTestArticleDto() {
        ArticleDTO articleDTO = new ArticleDTO();
        articleDTO.setHeader("test_Header_1");
        articleDTO.setShortDescription("Sample_HTML_Article");
        articleDTO.setText("<ul><li>line 1</li><li>line 2</li><p>");
        return articleDTO;
    }
}
