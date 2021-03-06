package sk.simo.sdjpaintro.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import sk.simo.sdjpaintro.domain.AuthorUuid;
import sk.simo.sdjpaintro.domain.Book;
import sk.simo.sdjpaintro.domain.BookUuid;
import sk.simo.sdjpaintro.repositories.AuthorUuidRepository;
import sk.simo.sdjpaintro.repositories.BookRepository;
import sk.simo.sdjpaintro.repositories.BookUuidRepository;

@Component
@Profile({"local", "default"})
public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final BookUuidRepository bookUuidRepository;
    private final AuthorUuidRepository authorUuidRepository;

    public DataInitializer(BookRepository bookRepository, AuthorUuidRepository authorUuidRepository, BookUuidRepository bookUuidRepository){
        this.bookRepository = bookRepository;
        this.authorUuidRepository = authorUuidRepository;
        this.bookUuidRepository = bookUuidRepository;
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

        authorUuidRepository.deleteAll();

        AuthorUuid authorUuid = new AuthorUuid();
        authorUuid.setFirstName("Joe");
        authorUuid.setLastName("Buck");
        AuthorUuid savedAuthor = authorUuidRepository.save(authorUuid);
        System.out.println("Saved Author UUID: " + savedAuthor.getId());

        bookUuidRepository.deleteAll();

        BookUuid bookUuid = new BookUuid();
        bookUuid.setTitle("All about UUIDs");
        BookUuid savedBookUuid = bookUuidRepository.save(bookUuid);
        System.out.println("Saved Book UUID: " + savedBookUuid.getId());
    }
}
