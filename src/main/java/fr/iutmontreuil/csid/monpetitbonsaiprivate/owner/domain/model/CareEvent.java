package fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.domain.model;

import fr.iutmontreuil.csid.monpetitbonsaiprivate.commons.persistence.CareType;

import java.time.LocalDate;
import java.util.UUID;

public class CareEvent {
    private UUID id;
    private LocalDate careDate;
    private Owner owner;
    private Bonsai bonsai;
    private CareType careType;

    public CareEvent(UUID id, LocalDate careDate, Owner owner, Bonsai bonsai, CareType careType) {
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

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Bonsai getBonsai() {
        return bonsai;
    }

    public void setBonsai(Bonsai bonsai) {
        this.bonsai = bonsai;
    }

    public CareType getCareType() {
        return careType;
    }

    public void setCareType(CareType careType) {
        this.careType = careType;
    }
}
