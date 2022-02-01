package fr.iutmontreuil.csid.monpetitbonsaiprivate.commons.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OwnerDao extends JpaRepository<OwnerEntity, UUID> {
}
