package fr.iutmontreuil.csid.monpetitbonsaiprivate.commons.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface CareEventDao extends JpaRepository<CareEventEntity, UUID> {

    @Query(value = "select *  from bonsai.care_event where bonsai_id =:val", nativeQuery = true)
    List<CareEventEntity> findByBonsai(@Param("val") UUID val);
}
