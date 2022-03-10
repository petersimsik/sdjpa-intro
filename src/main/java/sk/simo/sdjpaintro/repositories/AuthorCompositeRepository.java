package sk.simo.sdjpaintro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.simo.sdjpaintro.domain.AuthorUuid;
import sk.simo.sdjpaintro.domain.composite.AuthorComposite;
import sk.simo.sdjpaintro.domain.composite.NameId;

import java.util.UUID;

public interface AuthorCompositeRepository extends JpaRepository<AuthorComposite, NameId> {
}
