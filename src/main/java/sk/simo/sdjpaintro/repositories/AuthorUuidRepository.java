package sk.simo.sdjpaintro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.simo.sdjpaintro.domain.AuthorUuid;

import java.util.UUID;

public interface AuthorUuidRepository extends JpaRepository<AuthorUuid, UUID> {
}
