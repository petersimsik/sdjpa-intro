package sk.simo.sdjpaintro.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sk.simo.sdjpaintro.domain.Book;
import sk.simo.sdjpaintro.repositories.BookRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;

    public DataInitializer(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Book book1 = new Book("Domain driven design", "123", "RandomHouse");
        Book savedBook1 = bookRepository.save(book1);

        Book book2 = new Book("Spring in action", "625165", "Author");
        Book savedbook2 = bookRepository.save(book2);

        //get list of book that were saved
        bookRepository.findAll().forEach(book -> System.out.println(book));
    }
}
