package fr.iutmontreuil.csid.monpetitbonsaiprivate.bonsai.domain;

import fr.iutmontreuil.csid.monpetitbonsaiprivate.bonsai.CareEventMapper;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.bonsai.domain.model.Bonsai;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.bonsai.exposition.dto.BonsaiDTO;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.bonsai.exposition.dto.CareEventDto;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.bonsai.repository.BonsaiRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BonsaiService {

    private final BonsaiRepository bonsaiRepository;

    public BonsaiService(BonsaiRepository bonsaiRepository) {
        this.bonsaiRepository = bonsaiRepository;
    }

    public Optional<Bonsai> findById(UUID uuid) {
        return bonsaiRepository.findById(uuid);
    }

    public List<Bonsai> findAll(String status){
        return bonsaiRepository.findAll(status);
    }


    public Bonsai create(Bonsai bonsai) {
        return bonsaiRepository.create(bonsai);
    }


    public Bonsai update(Bonsai bonsai,UUID uuid) {
        Bonsai bonsai1Founded = this.findById(uuid).get();

        if(bonsai.getName() != null){
            bonsai1Founded.setName(bonsai.getName());
        }
        if(bonsai.getSpecies() != null){
            bonsai1Founded.setSpecies(bonsai.getSpecies());
        }

        if(bonsai.getStatus() != null){
            bonsai1Founded.setStatus(bonsai.getStatus());
        }
        return bonsaiRepository.update(bonsai1Founded);
    }


    public void delete(UUID uuid){
        bonsaiRepository.delete(uuid);
    }

    public void changeStatus(BonsaiDTO bonsaiDTO, UUID uuid){
        Bonsai bonsai1Founded = this.findById(uuid).get();
        if(bonsaiDTO.getStatus().equals("alive") || bonsaiDTO.getStatus().equals("unknown") || bonsaiDTO.getStatus().equals("dead")){
            bonsai1Founded.setStatus(bonsaiDTO.getStatus());
        }
        bonsaiRepository.changeStatus(bonsai1Founded);
    }

    public List<CareEventDto> findAllBonsaiEvents(UUID id) {
        return(CareEventMapper.mapModelsToDTOS(bonsaiRepository.findAllBonsaiEvents(id)));
    }




}
