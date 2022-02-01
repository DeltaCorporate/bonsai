package fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.domain.model;

import java.util.UUID;

public class Owner {

    private final UUID id;
    private String name;




    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Owner(UUID id, String name) {
        this.id = id;
        this.name = name;
    }
}
