package sk.simo.sdjpaintro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.simo.sdjpaintro.domain.BookNatural;
import sk.simo.sdjpaintro.domain.BookUuid;

import java.util.UUID;

public interface BookNaturalRepository extends JpaRepository<BookNatural, String> {
}
