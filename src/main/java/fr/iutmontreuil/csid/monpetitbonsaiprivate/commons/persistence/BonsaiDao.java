package fr.iutmontreuil.csid.monpetitbonsaiprivate.commons.persistence;

import fr.iutmontreuil.csid.monpetitbonsaiprivate.bonsai.domain.model.Bonsai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public interface BonsaiDao extends JpaRepository<BonsaiEntity, UUID> {

    @Query(value = "SELECT * from bonsai.bonsai bonsai  where bonsai.status =:status ", nativeQuery = true)
    List<BonsaiEntity> findAllByStatus(@Param("status") String status);
}
