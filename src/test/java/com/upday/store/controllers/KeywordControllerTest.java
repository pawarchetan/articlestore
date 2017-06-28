package com.upday.store.controllers;

import com.upday.store.domains.Article;
import com.upday.store.services.KeywordService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(KeywordController.class)
public class KeywordControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private KeywordService keywordService;

    @Test
    public void testFindAllArticlesForKeyword() throws Exception {
        Set<Article> articles = new HashSet<>();
        articles.add(TestDataBuilder.getTestArticleOne());
        when(keywordService.findAllArticlesForKeyword("java")).thenReturn(articles);
        mvc.perform(get("/api/keywords/java"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith("application/json"))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is("test_article_id_1")))
                .andExpect(jsonPath("$[0].shortDescription", is("Sample_HTML_Article")))
                .andExpect(jsonPath("$[0].header", is("test_Header_1")))
                .andExpect(jsonPath("$[0].text", is("<ul><li>line 1</li><li>line 2</li><p>")));
    }
}
