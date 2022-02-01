package fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.exposition.dto;

import java.util.Set;
import java.util.UUID;

public class OwnerDTO {

    private UUID id;
    private String name;
    private Set<BonsaiDTO> bonsaiDTOS;

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

    public Set<BonsaiDTO> getBonsaiDTOS() {
        return bonsaiDTOS;
    }

    public void setBonsaiDTOS(Set<BonsaiDTO> bonsaiDTOS) {
        this.bonsaiDTOS = bonsaiDTOS;
    }

    public OwnerDTO(){};


}
