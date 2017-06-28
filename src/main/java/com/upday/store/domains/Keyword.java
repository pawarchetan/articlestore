package com.upday.store.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "keyword_tbl")
public class Keyword {
    private static final int MAX_LENGTH_WORD = 150;

    @Id
    @GeneratedValue(generator = "customuuid")
    @GenericGenerator(name = "customuuid", strategy = "com.upday.store.util.RandomNumberGenerator")
    @Column(name = "Id", unique = true, nullable = false)
    private String id;

    @Column(nullable = false, length = MAX_LENGTH_WORD, unique = true)
    private String word;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "keywords", cascade = CascadeType.ALL)
    private Set<Article> articles = new HashSet<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Set<Article> getArticles() {
        return articles;
    }

    public void setArticles(Set<Article> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "Keyword{" +
                "id='" + id + '\'' +
                ", word='" + word + '\'' +
                ", articles=" + articles +
                '}';
    }
}
