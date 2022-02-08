package fr.iutmontreuil.csid.monpetitbonsaiprivate.owner;

import fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.domain.model.CareEvent;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.exposition.dto.CareEventDto;

public class CareEventMapper {

    public static CareEventDto mapModelToDtoCareEvent(CareEvent careEvent) {
        return new CareEventDto(careEvent.getId(), careEvent.getCareDate(), careEvent.getOwner(), careEvent.getBonsai(), careEvent.getCareType());
    }
}
