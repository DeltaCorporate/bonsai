package fr.iutmontreuil.csid.monpetitbonsaiprivate.bonsai;

import fr.iutmontreuil.csid.monpetitbonsaiprivate.bonsai.domain.model.Bonsai;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.bonsai.exposition.dto.BonsaiDTO;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.commons.persistence.BonsaiEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

// TODO: complete all the methods !
public class BonsaiMapper {

    public static BonsaiDTO mapModelToDto(Bonsai bonsai) {
        BonsaiDTO bonsaiDTO = new BonsaiDTO();
        bonsaiDTO.setName(bonsai.getName());
        bonsaiDTO.setId(bonsai.getId());
        bonsaiDTO.setSpecies(bonsai.getSpecies());
        bonsaiDTO.setStatus(bonsai.getStatus());
        return bonsaiDTO;
    }

    public static List<BonsaiDTO> mapModels(List<Bonsai> bonsais) {
        return Collections.emptyList();
    }

    public static Bonsai mapDtoToModel(BonsaiDTO bonsaiDTO) {
        UUID id = bonsaiDTO.getId();
        String name = bonsaiDTO.getName();
        String species = bonsaiDTO.getSpecies();
        String status = bonsaiDTO.getStatus();
        return new Bonsai(id, name, species,status);
    }

    public static List<Bonsai> mapDtosToModels(List<BonsaiDTO> bonsaiDTOS) {
        List<Bonsai> bonsais = new ArrayList<>();
        for (BonsaiDTO b: bonsaiDTOS
        ) {
            bonsais.add(BonsaiMapper.mapDtoToModel(b));
        }
        return bonsais;
    }

    public static BonsaiEntity mapModelToEntity(Bonsai bonsai) {
        BonsaiEntity bonsaiEntity = new BonsaiEntity();
        bonsaiEntity.setId(bonsai.getId());
        bonsaiEntity.setName(bonsai.getName());
        bonsaiEntity.setSpecies(bonsai.getSpecies());
        bonsaiEntity.setStatus(bonsai.getStatus());
        return bonsaiEntity;
    }

    public static List<BonsaiDTO> mapModelsToDtos(List<Bonsai> bonsais) {
        List<BonsaiDTO> listBonsaiDTO = new ArrayList<>();
        for (Bonsai b : bonsais) {
            listBonsaiDTO.add(BonsaiMapper.mapModelToDto(b));
        }
        return listBonsaiDTO;
    }

    public static Bonsai mapEntityToModel(BonsaiEntity bonsaiEntity) {

        return new Bonsai(bonsaiEntity.getId(), bonsaiEntity.getName(), bonsaiEntity.getSpecies(),bonsaiEntity.getStatus());
    }

    public static List<Bonsai> mapEntitiesToModels(List<BonsaiEntity> bonsaiEntities) {
        List<Bonsai> bonsais = new ArrayList<>();
        for (BonsaiEntity b: bonsaiEntities
             ) {
            bonsais.add(BonsaiMapper.mapEntityToModel(b));

        }
        return bonsais;
    }
}
