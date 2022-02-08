package fr.iutmontreuil.csid.monpetitbonsaiprivate.commons.persistence;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.UUID;

@Entity(name = "CareEvent")
@Table(name = "care_event")
public class CareEventEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "care_date")
    private LocalDate careDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "care_type")
    private CareType careType;

    @ManyToOne(targetEntity = BonsaiEntity.class)
    @JoinColumn(name = "bonsai_id")
    private BonsaiEntity bonsai;

    @ManyToOne(targetEntity = OwnerEntity.class)
    @JoinColumn(name = "care_owner_id")
    private OwnerEntity owner;


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

    public CareType getCareType() {
        return careType;
    }

    public void setCareType(CareType careType) {
        this.careType = careType;
    }

    public BonsaiEntity getBonsai() {
        return bonsai;
    }

    public void setBonsai(BonsaiEntity bonsai) {
        this.bonsai = bonsai;
    }

    public OwnerEntity getOwner() {
        return owner;
    }

    public void setOwner(OwnerEntity owner) {
        this.owner = owner;
    }
}
