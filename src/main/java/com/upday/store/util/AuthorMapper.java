package com.upday.store.util;

import com.upday.store.domains.Author;
import com.upday.store.domains.dto.AuthorDTO;

final class AuthorMapper {
    static Author mapAuthorDTOToAuthorEntity(AuthorDTO authorDTO) {
        Author author = new Author();
        author.setName(authorDTO.getName());
        return author;
    }
}
