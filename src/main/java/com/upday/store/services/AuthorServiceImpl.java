package com.upday.store.services;

import com.upday.store.domains.Article;
import com.upday.store.domains.Author;
import com.upday.store.exceptions.AuthorNotFoundException;
import com.upday.store.repository.AuthorRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
@Log4j2
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Set<Article> findAllArticlesWrittenByAuthor(String id) {
        Author author = authorRepository.findOne(id);
        log.error("Author with Id: " + id + " not Found.");
        if (author == null) {
            throw createAuthorNotFoundException(new Exception("Author Not Found"));
        }
        return author.getArticles();
    }

    @Override
    public Set<Article> findAllArticlesWrittenByAuthorName(String name) {
        Author author = authorRepository.findByName(name);
        log.error("Author with name: " + name + " not Found.");
        if (author == null) {
            throw createAuthorNotFoundException(new Exception("Author Not Found"));
        }
        return author.getArticles();
    }


    private AuthorNotFoundException createAuthorNotFoundException(Exception e) {
        String errorMessage = e.getLocalizedMessage();
        return new AuthorNotFoundException(errorMessage);
    }
}
