package com.upday.store.controllers;

import com.upday.store.domains.Article;
import com.upday.store.domains.dto.ArticleDTO;
import com.upday.store.services.ArticleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(ArticleController.class)
public class ArticleControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private ArticleService articleService;

    @Test
    public void testGetArticleById() throws Exception {
        when(articleService.findById("test_article_id_2")).thenReturn(TestDataBuilder.getTestArticleTwo());
        mvc.perform(get("/api/articles/test_article_id_2"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith("application/json"))
                .andExpect(jsonPath("id", is("test_article_id_2")))
                .andExpect(jsonPath("shortDescription", is("Sample_HTML_Article_2")))
                .andExpect(jsonPath("header", is("test_Header_2")))
                .andExpect(jsonPath("text", is("<ul><li>line 1</li><li>line 2</li><p></p>")));
    }

    @Test
    public void testGetArticlesPublishedWithinDateRange() throws Exception {
        List<Article> articles = new ArrayList<>();
        articles.add(TestDataBuilder.getTestArticleTwo());
        when(articleService.findArticlesPublishedWithinDateRange("2017-02-28", "2017-06-13")).thenReturn(articles);
        mvc.perform(get("/api/articles/date")
                .param("dateFrom", "2017-02-28")
                .param("dateTo", "2017-06-13"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith("application/json"))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is("test_article_id_2")))
                .andExpect(jsonPath("$[0].shortDescription", is("Sample_HTML_Article_2")))
                .andExpect(jsonPath("$[0].header", is("test_Header_2")))
                .andExpect(jsonPath("$[0].text", is("<ul><li>line 1</li><li>line 2</li><p></p>")));
    }

    @Test
    public void testCreateArticle() throws Exception {
        ArticleDTO articleDTO = TestDataBuilder.getTestArticleDto();
        String articleAsStringJson = TestDataBuilder.convertObjectToJsonBytes(articleDTO);
        when(articleService.create(anyObject())).thenReturn(TestDataBuilder.getTestArticleOne());
        mvc.perform(post("/api/articles")
                .accept("application/json")
                .contentType("application/json")
                .content(articleAsStringJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id", is("test_article_id_1")))
                .andExpect(jsonPath("shortDescription", is("Sample_HTML_Article")))
                .andExpect(jsonPath("header", is("test_Header_1")))
                .andExpect(jsonPath("text", is("<ul><li>line 1</li><li>line 2</li><p>")));
    }
}
