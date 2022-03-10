package sk.simo.sdjpaintro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.simo.sdjpaintro.domain.BookUuid;

import java.util.UUID;

public interface BookUuidRepository extends JpaRepository<BookUuid, UUID> {
}
