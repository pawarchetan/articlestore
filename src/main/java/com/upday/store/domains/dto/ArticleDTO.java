package com.upday.store.domains.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;
import java.util.Set;

@JsonSerialize(as = ArticleDTO.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ArticleDTO {
    @JsonProperty("id")
    private String id;

    @JsonProperty("header")
    private String header;

    @JsonProperty("shortDescription")
    private String shortDescription;

    @JsonProperty("text")
    private String text;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonProperty("publishDate")
    private Date publishDate;

    @JsonProperty("author")
    private AuthorDTO author;

    @JsonProperty("keywords")
    private Set<KeywordDTO> keywords;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }

    public Set<KeywordDTO> getKeywords() {
        return keywords;
    }

    public void setKeywords(Set<KeywordDTO> keywords) {
        this.keywords = keywords;
    }
}
