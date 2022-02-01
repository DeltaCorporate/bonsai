package fr.iutmontreuil.csid.monpetitbonsaiprivate.commons.persistence;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity(name = "Bonsai")
@Table(name = "bonsai")
public class BonsaiEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;


    @ManyToOne(targetEntity = OwnerEntity.class)
    @Column(name = "name")
    private String name;


    @Column(name = "status")
    private String status;



    @Column(name = "species")
    private String species;


    @Column(name = "age")
    private int age;





    @Column(name="acquisition_date")
    private LocalDate acquisition_date;



    public BonsaiEntity() {
    }

    public LocalDate getAcquisition_date() {
        return acquisition_date;
    }

    public void setAcquisition_date(LocalDate acquisition_date) {
        this.acquisition_date = acquisition_date;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public UUID getId() {
        return id;
    }

    public String getName(){
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

    public void setId(UUID id) {
        this.id = id;
    }
public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

