package sk.simo.sdjpaintro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.simo.sdjpaintro.domain.composite.AuthorComposite;
import sk.simo.sdjpaintro.domain.composite.AuthorEmbedded;
import sk.simo.sdjpaintro.domain.composite.NameId;

public interface AuthorEmbeddedRepository extends JpaRepository<AuthorEmbedded, NameId> {
}
