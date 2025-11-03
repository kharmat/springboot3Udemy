package kharmat.springframework.spring6webapp.controllers;

import ch.qos.logback.core.model.Model;
import kharmat.springframework.spring6webapp.domain.Book;
import kharmat.springframework.spring6webapp.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/books")
    public String getBooks(Model model) {

        model.addAttribute("books", bookService.findAll());

        return "books";
    }
}
