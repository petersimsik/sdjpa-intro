package sk.simo.sdjpaintro.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import sk.simo.sdjpaintro.domain.Book;
import sk.simo.sdjpaintro.repositories.BookRepository;

@Component
@Profile({"local", "default"})
public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;

    public DataInitializer(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        bookRepository.deleteAll();

        Book book1 = new Book("Domain driven design", "123", "RandomHouse", null);
        Book savedBook1 = bookRepository.save(book1);

        Book book2 = new Book("Spring in action", "625165", "Author", null);
        Book savedbook2 = bookRepository.save(book2);

        //get list of book that were saved
        bookRepository.findAll().forEach(book -> System.out.println(book));
    }
}
