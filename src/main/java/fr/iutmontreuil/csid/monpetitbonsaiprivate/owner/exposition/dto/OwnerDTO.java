package fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.exposition.dto;

import java.util.UUID;

public class OwnerDTO {
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

    private UUID id;
    private String name;

    public OwnerDTO(){};


}
