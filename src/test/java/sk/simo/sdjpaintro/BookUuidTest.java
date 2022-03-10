package sk.simo.sdjpaintro;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import sk.simo.sdjpaintro.domain.BookUuid;
import sk.simo.sdjpaintro.repositories.BookUuidRepository;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("local")
@DataJpaTest
@ComponentScan("sk.simo.sdjpaintro.bootstrap")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BookUuidTest {

    @Autowired
    BookUuidRepository bookUuidRepository;

    @Test
    void saveOperationTest() {
        Long countBefore = bookUuidRepository.count();
        BookUuid book = new BookUuid();
        book.setTitle("Moja pekna knizka");
        book.setPublisher("Bla");
        BookUuid savedBook = bookUuidRepository.save(book);

        assertThat(countBefore).isNotEqualTo(bookUuidRepository.count());
    }

    @Test
    void getByIdTest() {
        BookUuid book = new BookUuid();
        book.setTitle("Moja pekna knizka");
        book.setPublisher("Bla");
        BookUuid savedBook = bookUuidRepository.save(book);
        UUID uuid = savedBook.getId();

        BookUuid bookFromDb = bookUuidRepository.getById(uuid);

        assertThat(bookFromDb).isEqualTo(savedBook);
    }
}
