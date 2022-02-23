package sk.simo.sdjpaintro;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Commit;
import sk.simo.sdjpaintro.domain.Book;
import sk.simo.sdjpaintro.repositories.BookRepository;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest
@ComponentScan("sk.simo.sdjpaintro.bootstrap")
public class SpringBootJpaSplice {

    @Autowired
    BookRepository bookRepository;

    @Test
    @Commit
    @Order(1)
    void testJpaTestSplice() {
        long countBefore = bookRepository.count();
        bookRepository.save(new Book("myBook","123456", "self"));
        long countAfter = bookRepository.count();

        assertThat(countBefore).isNotSameAs(countAfter);
    }

    @Test
    @Order(2)
    void testAnotherTest(){
        long count = bookRepository.count();
        assertThat(count).isEqualTo(1);
    }
}
