package fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.exposition.dto;

import fr.iutmontreuil.csid.monpetitbonsaiprivate.commons.persistence.CareType;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.domain.model.Bonsai;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.domain.model.Owner;

import java.time.LocalDate;
import java.util.UUID;

public class CareEventDto {
    private UUID id;
    private LocalDate careDate;
    private OwnerDTO owner;
    private BonsaiDTO bonsai;
    private CareType careType;

    public CareEventDto(UUID id, LocalDate careDate, OwnerDTO owner, BonsaiDTO bonsai, CareType careType) {
        this.id = id;
        this.careDate = careDate;
        this.owner = owner;
        this.bonsai = bonsai;
        this.careType = careType;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getCareDate() {
        return careDate;
    }

    public void setCareDate(LocalDate careDate) {
        this.careDate = careDate;
    }

    public OwnerDTO getOwner() {
        return owner;
    }

    public void setOwner(OwnerDTO owner) {
        this.owner = owner;
    }

    public BonsaiDTO getBonsai() {
        return bonsai;
    }

    public void setBonsai(BonsaiDTO bonsai) {
        this.bonsai = bonsai;
    }

    public CareType getCareType() {
        return careType;
    }

    public void setCareType(CareType careType) {
        this.careType = careType;
    }
}
