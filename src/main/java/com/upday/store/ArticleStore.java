package com.upday.store;


import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Log4j2
public class ArticleStore {
    public static void main(String[] args) {
        log.info("Starting and Configuring Article Store !!!!!!!");
        SpringApplication.run(ArticleStore.class, args);
    }
}
