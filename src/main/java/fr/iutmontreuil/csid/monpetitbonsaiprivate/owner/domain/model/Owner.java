package fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.domain.model;

import fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.exposition.dto.BonsaiDTO;

import java.util.List;
import java.util.UUID;

public class Owner {

    private final UUID id;
    private String name;
    private List<Bonsai> bonsais;

    public List<Bonsai> getBonsais() {
        return bonsais;
    }

    public void setBonsais(List<Bonsai> bonsais) {
        this.bonsais = bonsais;
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

    public Owner(UUID id, String name) {
        this.id = id;
        this.name = name;
    }
}
