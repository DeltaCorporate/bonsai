package fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.domain.model;

import fr.iutmontreuil.csid.monpetitbonsaiprivate.bonsai.domain.model.CareEvent;

import java.util.List;
import java.util.UUID;

public class Bonsai {

    private final UUID id;
    private String name;
    private String species;
    private int age;



    private List<CareEvent> careEvents;

// Add the missing fields

    public Bonsai(UUID id, String name, String species,int age) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.age = age;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public List<CareEvent> getCareEvents() {
        return careEvents;
    }

    public void setCareEvents(List<CareEvent> careEvents) {
        this.careEvents = careEvents;
    }

}
