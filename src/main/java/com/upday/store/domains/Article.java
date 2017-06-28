package com.upday.store.domains;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "article_tbl")
public class Article implements Serializable {
    private static final int MAX_LENGTH_DESCRIPTION = 500;
    private static final int MAX_LENGTH_HEADER = 150;

    @Id
    @GeneratedValue(generator = "customuuid")
    @GenericGenerator(name = "customuuid", strategy = "com.upday.store.util.RandomNumberGenerator")
    @Column(name = "Id", unique = true, nullable = false)
    private String id;

    @Column(nullable = false, length = MAX_LENGTH_HEADER)
    private String header;

    @Column(nullable = false, length = MAX_LENGTH_DESCRIPTION)
    private String shortDescription;

    @Lob
    @Column(nullable = false)
    private String text;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date publishDate;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private Author author;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "article_keyword", joinColumns = {@JoinColumn(name = "article_id")}, inverseJoinColumns = {@JoinColumn(name = "keyword_id")})
    private Set<Keyword> keywords = new HashSet<>();

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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Set<Keyword> getKeywords() {
        return keywords;
    }

    public void setKeywords(Set<Keyword> keywords) {
        this.keywords = keywords;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", header='" + header + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", text='" + text + '\'' +
                ", publishDate=" + publishDate +
                ", author=" + author +
                ", keywords=" + keywords +
                '}';
    }
}
