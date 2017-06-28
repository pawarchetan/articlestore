package com.upday.store.repository;

import com.upday.store.domains.Article;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ArticleRepository extends CrudRepository<Article, String> {

    @Query("SELECT a FROM Article a WHERE a.publishDate >= :dateFrom and a.publishDate <= :dateTo ")
    List<Article> findArticlesByDateRange(@Param("dateFrom") Date dateFrom, @Param("dateTo") Date dateTo);
}
