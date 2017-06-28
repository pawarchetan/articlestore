package com.upday.store.repository;

import com.upday.store.domains.Keyword;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface KeywordRepository extends CrudRepository<Keyword, String> {
    Keyword findByWord(String word);
}
