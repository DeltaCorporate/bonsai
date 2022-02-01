package fr.iutmontreuil.csid.monpetitbonsaiprivate.bonsai.domain.model;

import java.util.UUID;

public class Bonsai {

    private final UUID id;
    private String name;
    private String species;
    private String status;

    // Add the missing fields

    public Bonsai(UUID id, String name, String species,String status) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.status = status;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
}
