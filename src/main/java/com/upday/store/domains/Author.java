package com.upday.store.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "author_tbl")
public class Author {
    private static final int MAX_LENGTH_NAME = 300;

    @Id
    @GeneratedValue(generator = "customuuid")
    @GenericGenerator(name = "customuuid", strategy = "com.upday.store.util.RandomNumberGenerator")
    @Column(name = "Id", unique = true, nullable = false)
    private String id;

    @Column(length = MAX_LENGTH_NAME)
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private Set<Article> articles = new HashSet<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Article> getArticles() {
        return articles;
    }

    public void setArticles(Set<Article> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", articles=" + articles +
                '}';
    }
}
