package com.upday.store.util;


import com.upday.store.domains.Keyword;
import com.upday.store.domains.dto.ArticleDTO;
import com.upday.store.domains.dto.KeywordDTO;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class KeywordMapper {
    //logic to avoid insertion of duplicate keywords
    static Set<Keyword> mapKeywordDTOsToPersistableEntities(ArticleDTO articleDTO, Iterable<Keyword> iterable) {
        Set<Keyword> keywordsToPersist = new HashSet<>();
        Map<String, Keyword> keywordMap = new HashMap<>();

        Set<KeywordDTO> keywordDTOS = articleDTO.getKeywords();
        iterable.forEach(i -> keywordMap.put(i.getWord(), i));

        keywordDTOS.forEach(j -> {
            if (keywordMap.containsKey(j.getWord())) {
                keywordsToPersist.add(keywordMap.get(j.getWord()));
            } else {
                Keyword mappedKeyword = KeywordMapper.mapKeywordDTOToKeywordEntity(j);
                keywordsToPersist.add(mappedKeyword);
            }
        });
        return keywordsToPersist;
    }

    private static Keyword mapKeywordDTOToKeywordEntity(KeywordDTO keywordDTO) {
        Keyword keyword = new Keyword();
        keyword.setId(keywordDTO.getId());
        keyword.setWord(keywordDTO.getWord());
        return keyword;
    }
}
