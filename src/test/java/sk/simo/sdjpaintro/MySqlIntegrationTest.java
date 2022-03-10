package sk.simo.sdjpaintro;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import sk.simo.sdjpaintro.domain.AuthorUuid;
import sk.simo.sdjpaintro.domain.BookNatural;
import sk.simo.sdjpaintro.domain.BookUuid;
import sk.simo.sdjpaintro.domain.composite.AuthorComposite;
import sk.simo.sdjpaintro.domain.composite.NameId;
import sk.simo.sdjpaintro.repositories.*;

import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ActiveProfiles("local")
@DataJpaTest
@ComponentScan("sk.simo.sdjpaintro.bootstrap")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MySqlIntegrationTest {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookUuidRepository bookUuidRepository;

    @Autowired
    AuthorUuidRepository authorUuidRepository;

    @Autowired
    BookNaturalRepository bookNaturalRepository;

    @Autowired
    AuthorCompositeRepository authorCompositeRepository;

    @Test
    void saveAuthorCompositeTest() {
        AuthorComposite author = new AuthorComposite();
        author.setFirstName("Peter");
        author.setLastName("Simsik");
        author.setCountry("SK");
        AuthorComposite savedAuthor = authorCompositeRepository.save(author);

        assertThat(savedAuthor).isNotNull();

        NameId id = new NameId();
        id.setFirstName("Peter");
        id.setLastName("Simsik");

        AuthorComposite fetched = authorCompositeRepository.getById(id);
        assertThat(fetched).isNotNull();
    }

    @Test
    void saveBookNaturalTest(){
        BookNatural bookNatural = new BookNatural();
        bookNatural.setTitle("My book");
        BookNatural saved = bookNaturalRepository.save(bookNatural);
        assertThat(saved).isNotNull();

        assertThat(bookNaturalRepository.getById(saved.getTitle())).isNotNull();
    }

    @Test
    void saveAuthorUuidTest() {
        long countBefore = authorUuidRepository.count();
        AuthorUuid author = new AuthorUuid();
        author.setFirstName("Peter");
        author.setLastName("Simsik");
        AuthorUuid savedAuthor = authorUuidRepository.save(author);

        Assertions.assertThat(countBefore).isNotEqualTo(authorUuidRepository.count());
    }

    @Test
    void getAuthorUuidByIdTest() {
        AuthorUuid author = new AuthorUuid();
        author.setFirstName("Peter");
        author.setLastName("Simsik");
        AuthorUuid savedAuthor = authorUuidRepository.save(author);
        UUID savedUUID = savedAuthor.getId();

        AuthorUuid authorFromDb = authorUuidRepository.getById(savedUUID);
        Assertions.assertThat(authorFromDb).isEqualTo(savedAuthor);

    }

    @Test
    void saveBookUuidTest() {
        Long countBefore = bookUuidRepository.count();
        BookUuid book = new BookUuid();
        book.setTitle("Moja pekna knizka");
        book.setPublisher("Bla");
        BookUuid savedBook = bookUuidRepository.save(book);

        Assertions.assertThat(countBefore).isNotEqualTo(bookUuidRepository.count());
    }

    @Test
    void getBookUuidByIdTest() {
        BookUuid book = new BookUuid();
        book.setTitle("Moja pekna knizka");
        book.setPublisher("Bla");
        BookUuid savedBook = bookUuidRepository.save(book);
        UUID uuid = savedBook.getId();

        BookUuid bookFromDb = bookUuidRepository.getById(uuid);

        Assertions.assertThat(bookFromDb).isEqualTo(savedBook);
    }

    @Test
    void testMySQL(){
        long count = bookRepository.count();
        assertThat(count).isEqualTo(2);
    }
}
