package fr.iutmontreuil.csid.monpetitbonsaiprivate.bonsai.exposition.dto;

import fr.iutmontreuil.csid.monpetitbonsaiprivate.commons.persistence.CareType;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.domain.model.Bonsai;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.domain.model.Owner;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.exposition.dto.BonsaiDTO;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.exposition.dto.OwnerDTO;

import java.time.LocalDate;
import java.util.UUID;

public class CareEventDto {
    private UUID id;
    private LocalDate careDate;
    private UUID owner;
    private UUID bonsai;
    private CareType careType;
    public CareEventDto(){};

    public CareEventDto(UUID id, LocalDate careDate, UUID owner, UUID bonsai, CareType careType) {
        this.id = id;
        this.careDate = careDate;
        this.owner = owner;
        this.bonsai = bonsai;
        this.careType = careType;
    }

    public LocalDate getCareDate() {
        return careDate;
    }

    public void setCareDate(LocalDate careDate) {
        this.careDate = careDate;
    }

    public UUID getOwner() {
        return owner;
    }

    public void setOwner(UUID owner) {
        this.owner = owner;
    }

    public UUID getBonsai() {
        return bonsai;
    }

    public void setBonsai(UUID bonsai) {
        this.bonsai = bonsai;
    }

    public CareType getCareType() {
        return careType;
    }

    public void setCareType(CareType careType) {
        this.careType = careType;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
