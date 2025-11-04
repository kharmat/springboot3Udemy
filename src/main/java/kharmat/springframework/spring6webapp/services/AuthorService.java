package kharmat.springframework.spring6webapp.services;

import kharmat.springframework.spring6webapp.domain.Author;

public interface AuthorService {

    Iterable<Author> findAll();
}
