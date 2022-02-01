package fr.iutmontreuil.csid.monpetitbonsaiprivate.commons.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Embeddable
public class CareEventCompoundKey implements Serializable {

    @Column(name = "bonsai_id")
    private UUID bonsaiId;

    @Column(name = "datetime")
    private LocalDateTime dateTime;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private CareType type;

    public CareEventCompoundKey() {

    }

    public CareEventCompoundKey(UUID bonsaiId, LocalDateTime dateTime, CareType type) {
        this.bonsaiId = bonsaiId;
        this.dateTime = dateTime;
        this.type = type;
    }


    public UUID getBonsaiId() {
        return bonsaiId;
    }

    public void setBonsaiId(UUID bonsaiId) {
        this.bonsaiId = bonsaiId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public CareType getType() {
        return type;
    }

    public void setType(CareType type) {
        this.type = type;
    }
}
