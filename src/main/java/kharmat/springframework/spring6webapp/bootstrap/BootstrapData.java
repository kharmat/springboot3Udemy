package kharmat.springframework.spring6webapp.bootstrap;

import kharmat.springframework.spring6webapp.domain.Author;
import kharmat.springframework.spring6webapp.domain.Book;
import kharmat.springframework.spring6webapp.domain.Publisher;
import kharmat.springframework.spring6webapp.repositories.AuthorRepository;
import kharmat.springframework.spring6webapp.repositories.BookRepository;
import kharmat.springframework.spring6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Harrison");

        Book book1 = new Book();
        book1.setTitle("Eric's Book");
        book1.setIsbn("123456789");

        Author ericSaved = authorRepository.save(eric);
        Book ericSavedBook = bookRepository.save(book1);

        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");

        Book noEJBBook = new Book();
        noEJBBook.setTitle("NoEJB");
        noEJBBook.setIsbn("123456781");

        Author rodSaved = authorRepository.save(rod);
        Book noEJBSaved = bookRepository.save(noEJBBook);

        ericSaved.getBooks().add(ericSavedBook);
        rodSaved.getBooks().add(noEJBSaved);

        Publisher publisher = new Publisher();
        publisher.setPublisherName("Libri");
        publisher.setAddress("Kossuth Lajos utca 1");
        publisher.setCity("Budapest");
        publisher.setZip("1051");
        Publisher savedPublisher = publisherRepository.save(publisher);

        ericSavedBook.setPublisher(savedPublisher);
        noEJBBook.setPublisher(savedPublisher);

        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);
        bookRepository.save(ericSavedBook);
        bookRepository.save(noEJBBook);


//        ericSavedBook.getAuthors().add(ericSaved);
//        noEJBBook.getAuthors().add(rodSaved);



        System.out.println("In Bootstrap");
        System.out.println("Author count: " + authorRepository.count());
        System.out.println("Book count: " + bookRepository.count());
        System.out.println("Publisher count: " + publisherRepository.count());

    }
}
