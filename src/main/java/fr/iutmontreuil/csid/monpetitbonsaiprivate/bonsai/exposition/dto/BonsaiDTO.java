package fr.iutmontreuil.csid.monpetitbonsaiprivate.bonsai.exposition.dto;

import java.util.UUID;

public class BonsaiDTO {

    private UUID id;

    private String name;
    private String species;


    private String status;

    public BonsaiDTO() {
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

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }


}
