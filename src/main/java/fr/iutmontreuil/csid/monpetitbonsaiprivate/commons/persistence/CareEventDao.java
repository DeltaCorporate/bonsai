package fr.iutmontreuil.csid.monpetitbonsaiprivate.commons.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface CareEventDao extends JpaRepository<CareEventEntity, UUID> {

    @Query(value = "select *  from bonsai.care_event where bonsai_id =:val", nativeQuery = true)
    List<CareEventEntity> findByBonsai(@Param("val") UUID val);

    @Modifying
    @Query(value = "DELETE from bonsai.care_event where bonsai_id=:bonsaiID and id=:id",nativeQuery = true)
    void deleteEvent(@Param("bonsaiID") UUID bonsaiID, @Param("id") UUID eventID);

    @Query(value = "select *  from bonsai.care_event where bonsai_id =:val and care_type=:type", nativeQuery = true)
    List<CareEventEntity> findBonsaiByEvent(@Param("val") UUID val, @Param("type") String type);
}
