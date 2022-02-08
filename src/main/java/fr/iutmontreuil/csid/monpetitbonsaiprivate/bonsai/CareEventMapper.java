package fr.iutmontreuil.csid.monpetitbonsaiprivate.bonsai;

import fr.iutmontreuil.csid.monpetitbonsaiprivate.commons.persistence.CareEventEntity;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.bonsai.domain.model.CareEvent;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.OwnerMapper;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.bonsai.exposition.dto.CareEventDto;

import java.util.ArrayList;
import java.util.List;

public class CareEventMapper {

    public static CareEvent mapDTOtoModel(CareEventDto careEventDTO) {
        return new CareEvent(careEventDTO.getId(), careEventDTO.getCareDate(), OwnerMapper.mapDtoToModelOwner(careEventDTO.getOwner()), OwnerMapper.mapDtoToModelBonsai(careEventDTO.getBonsai()), careEventDTO.getCareType());
    }

    public static CareEventEntity mapModelToEntity(CareEvent careEvent) {
        CareEventEntity careEventEntity = new CareEventEntity();
        careEventEntity.setId(careEvent.getId());
        careEventEntity.setCareDate(careEvent.getCareDate());
        careEventEntity.setOwner(OwnerMapper.mapModelToEntityOwner(careEvent.getOwner()));
        careEventEntity.setBonsai(OwnerMapper.mapModelToEntityBonsai(careEvent.getBonsai()));
        careEventEntity.setCareType(careEvent.getCareType());
        return careEventEntity;
    }


    public static CareEvent mapEntityToModel(CareEventEntity careEventEntity) {
        return new CareEvent(careEventEntity.getId(), careEventEntity.getCareDate(), OwnerMapper.mapEntityToModelOwner(careEventEntity.getOwner()), OwnerMapper.mapEntityToModelBonsai(careEventEntity.getBonsai()), careEventEntity.getCareType());
    }

    public static CareEventDto mapModelToDto(CareEvent careEvent) {
        return new CareEventDto(careEvent.getId(), careEvent.getCareDate(), OwnerMapper.mapModelToDtoOwner(careEvent.getOwner()), OwnerMapper.mapModelToDtoBonsai(careEvent.getBonsai()), careEvent.getCareType());
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
