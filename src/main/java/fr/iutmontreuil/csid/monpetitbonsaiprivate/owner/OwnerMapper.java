package fr.iutmontreuil.csid.monpetitbonsaiprivate.owner;


import fr.iutmontreuil.csid.monpetitbonsaiprivate.commons.persistence.BonsaiEntity;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.commons.persistence.OwnerEntity;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.domain.model.Bonsai;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.domain.model.Owner;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.exposition.dto.BonsaiDTO;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.exposition.dto.OwnerDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OwnerMapper {

    public static OwnerDTO mapModelToDtoOwner(Owner owner) {
        OwnerDTO OwnerDto = new OwnerDTO();
        OwnerDto.setName(owner.getName());
        OwnerDto.setId(owner.getId());
        OwnerDto.setBonsais(OwnerMapper.mapModelsToDtosBonsai(owner.getBonsais()));
        return OwnerDto;
    }

    public static Owner mapDtoToModelOwner(OwnerDTO ownerDTO) {
        UUID id = ownerDTO.getId();
        String name = ownerDTO.getName();
        List<BonsaiDTO> bonsaiDTOList= ownerDTO.getBonsais();
        Owner owner = new Owner(id, name);
        owner.setBonsais(OwnerMapper.mapDtosToModelsBonsai(bonsaiDTOList));
        return owner;
    }

    public static List<Owner> mapDtosToModelsOwner(List<OwnerDTO> ownerDTOS) {
        List<Owner> owners = new ArrayList<>();
        for (OwnerDTO b : ownerDTOS
        ) {
            owners.add(OwnerMapper.mapDtoToModelOwner(b));
        }
        return owners;
    }


    public static OwnerEntity mapModelToEntityOwner(Owner owner) {
        OwnerEntity ownerEntity = new OwnerEntity();
        ownerEntity.setId(owner.getId());
        ownerEntity.setName(owner.getName());
        return ownerEntity;
    }

    public static List<OwnerDTO> mapModelsToDtosOwner(List<Owner> owners) {
        List<OwnerDTO> listBonsaiDTO = new ArrayList<>();
        for (Owner b : owners) {
            listBonsaiDTO.add(OwnerMapper.mapModelToDtoOwner(b));
        }
        return listBonsaiDTO;
    }

    public static Owner mapEntityToModelOwner(OwnerEntity ownerEntity) {
        Owner owner = new Owner(ownerEntity.getId(), ownerEntity.getName());
        owner.setBonsais(OwnerMapper.mapEntitiesToModelsBonsai(ownerEntity.getBonsaiEntities()));
        return owner;
    }

    public static BonsaiDTO mapModelToDto(Bonsai bonsai) {
        BonsaiDTO bonsaiDTO = new BonsaiDTO();
        bonsaiDTO.setName(bonsai.getName());
        bonsaiDTO.setId(bonsai.getId());
        bonsaiDTO.setSpecies(bonsai.getSpecies());
        bonsaiDTO.setAge(bonsai.getAge());
        return bonsaiDTO;
    }


    public static List<Owner> mapEntitiesToModelsOwner(List<OwnerEntity> ownerEntities) {
        List<Owner> owners = new ArrayList<>();
        for (OwnerEntity b: ownerEntities
        ) {
            owners.add(OwnerMapper.mapEntityToModelOwner(b));

        }
        return owners;
    }


    public static Bonsai mapDtoToModelBonsai(BonsaiDTO bonsaiDTO) {
        UUID id = bonsaiDTO.getId();
        String name = bonsaiDTO.getName();
        String species = bonsaiDTO.getSpecies();
        int age = bonsaiDTO.getAge();
        return new Bonsai(id, name, species,age);
    }

    public static List<Bonsai> mapDtosToModelsBonsai(List<BonsaiDTO> bonsaiDTOS) {
        List<Bonsai> bonsais = new ArrayList<>();
        for (BonsaiDTO b: bonsaiDTOS
        ) {
            bonsais.add(OwnerMapper.mapDtoToModelBonsai(b));
        }
        return bonsais;
    }

    public static BonsaiEntity mapModelToEntityBonsai(Bonsai bonsai) {
        BonsaiEntity bonsaiEntity = new BonsaiEntity();
        bonsaiEntity.setId(bonsai.getId());
        bonsaiEntity.setName(bonsai.getName());
        bonsaiEntity.setSpecies(bonsai.getSpecies());
        bonsaiEntity.setAge(bonsai.getAge());
        return bonsaiEntity;
    }

    public static List<BonsaiDTO> mapModelsToDtosBonsai(List<Bonsai> bonsais) {
        List<BonsaiDTO> listBonsaiDTO = new ArrayList<>();
        for (Bonsai b : bonsais) {
            listBonsaiDTO.add(OwnerMapper.mapModelToDto(b));
        }
        return listBonsaiDTO;
    }

    public static Bonsai mapEntityToModelBonsai(BonsaiEntity bonsaiEntity) {

        return new Bonsai(bonsaiEntity.getId(), bonsaiEntity.getName(), bonsaiEntity.getSpecies(),bonsaiEntity.getAge());
    }

    public static List<Bonsai> mapEntitiesToModelsBonsai(List<BonsaiEntity> bonsaiEntities) {
        List<Bonsai> bonsais = new ArrayList<>();
        for (BonsaiEntity b: bonsaiEntities
        ) {
            bonsais.add(OwnerMapper.mapEntityToModelBonsai(b));

        }
        return bonsais;
    }

}
