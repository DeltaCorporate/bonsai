package fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.exposition.dto;

import java.util.UUID;

public class BonsaiDTO {
    private UUID id;


    private String name;
    private String species;
    private int age;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public BonsaiDTO() {}

}
