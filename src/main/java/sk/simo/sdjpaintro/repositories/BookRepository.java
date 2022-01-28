package sk.simo.sdjpaintro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.simo.sdjpaintro.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
