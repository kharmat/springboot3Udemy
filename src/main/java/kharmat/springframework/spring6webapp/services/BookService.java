package kharmat.springframework.spring6webapp.services;

import kharmat.springframework.spring6webapp.domain.Book;

public interface BookService {

    Iterable<Book> findAll();
}
