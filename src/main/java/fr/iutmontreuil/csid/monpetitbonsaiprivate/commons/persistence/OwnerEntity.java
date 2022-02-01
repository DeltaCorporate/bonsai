package fr.iutmontreuil.csid.monpetitbonsaiprivate.commons.persistence;


import fr.iutmontreuil.csid.monpetitbonsaiprivate.bonsai.domain.model.Bonsai;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity(name = "Owner")
@Table(name = "owner")
public class OwnerEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;


    @Column(name="name")
    private String name;


    @OneToMany(mappedBy = "ownerEntity")
    private List<BonsaiEntity> bonsaiEntities;

    public List<BonsaiEntity> getBonsaiEntities() {
        return bonsaiEntities;
    }

    public void setBonsaiEntities(List<BonsaiEntity> bonsaiEntities) {
        this.bonsaiEntities = bonsaiEntities;
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
