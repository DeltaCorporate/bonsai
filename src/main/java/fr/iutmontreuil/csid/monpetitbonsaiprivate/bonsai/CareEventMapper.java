package fr.iutmontreuil.csid.monpetitbonsaiprivate.bonsai;

import fr.iutmontreuil.csid.monpetitbonsaiprivate.commons.persistence.BonsaiEntity;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.commons.persistence.CareEventEntity;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.bonsai.domain.model.CareEvent;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.commons.persistence.OwnerEntity;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.OwnerMapper;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.bonsai.exposition.dto.CareEventDto;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class CareEventMapper {

    public static CareEvent mapDTOtoModel(CareEventDto careEventDTO) {
        return new CareEvent(careEventDTO.getId(), careEventDTO.getCareDate(), careEventDTO.getOwner(), careEventDTO.getBonsai(), careEventDTO.getCareType());
    }

    public static CareEventEntity mapModelToEntity(CareEvent careEvent) {
        OwnerEntity ownerEntity = new OwnerEntity();
        ownerEntity.setId(careEvent.getOwner());
        BonsaiEntity bonsaiEntity = new BonsaiEntity();
        bonsaiEntity.setId(careEvent.getBonsai());
        CareEventEntity careEventEntity = new CareEventEntity();
        careEventEntity.setId(careEvent.getId());
        careEventEntity.setCareDate(careEvent.getCareDate());
        careEventEntity.setOwner(ownerEntity);
        careEventEntity.setBonsai(bonsaiEntity);
        careEventEntity.setCareType(careEvent.getCareType());
        return careEventEntity;
    }


    public static CareEvent mapEntityToModel(CareEventEntity careEventEntity) {
        return new CareEvent(careEventEntity.getId(), careEventEntity.getCareDate(), careEventEntity.getOwner().getId(), careEventEntity.getBonsai().getId(), careEventEntity.getCareType());
    }

    public static CareEventDto mapModelToDto(CareEvent careEvent) {
        return new CareEventDto(careEvent.getId(), careEvent.getCareDate(), careEvent.getOwner(),careEvent.getBonsai(), careEvent.getCareType());
    }

    public static List<CareEventDto> mapModelsToDTOS(List<CareEvent> careEvents){
        List<CareEventDto> careEventDtos = new ArrayList<>();
        for(CareEvent careEvent : careEvents){
            careEventDtos.add(CareEventMapper.mapModelToDto(careEvent));
        }
        return careEventDtos;
    }

    public static List<CareEvent> mapEntitiesToModels(List<CareEventEntity> careEventEntities){
        ArrayList<CareEvent> careEvents = new ArrayList<>();
        for(CareEventEntity careEventEntity : careEventEntities){
            careEvents.add(CareEventMapper.mapEntityToModel(careEventEntity));
        }
        return careEvents;
    }
}
