package sk.simo.sdjpaintro;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ActiveProfiles;
import sk.simo.sdjpaintro.domain.AuthorUuid;
import sk.simo.sdjpaintro.repositories.AuthorUuidRepository;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("local")
@DataJpaTest
@ComponentScan("sk.simo.sdjpaintro.bootstrap")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AuthorUuidTest {

    @Autowired
    AuthorUuidRepository authorUuidRepository;

    @Test
    void saveOperationTest() {
        long countBefore = authorUuidRepository.count();
        AuthorUuid author = new AuthorUuid();
        author.setFirstName("Peter");
        author.setLastName("Simsik");
        AuthorUuid savedAuthor = authorUuidRepository.save(author);

        assertThat(countBefore).isNotEqualTo(authorUuidRepository.count());
    }

    @Test
    void getByIdTest() {
        AuthorUuid author = new AuthorUuid();
        author.setFirstName("Peter");
        author.setLastName("Simsik");
        AuthorUuid savedAuthor = authorUuidRepository.save(author);
        UUID savedUUID = savedAuthor.getId();

        AuthorUuid authorFromDb = authorUuidRepository.getById(savedUUID);
        assertThat(authorFromDb).isEqualTo(savedAuthor);

    }
}
