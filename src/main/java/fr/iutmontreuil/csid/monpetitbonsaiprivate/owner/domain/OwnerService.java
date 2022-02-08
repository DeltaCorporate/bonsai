package fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.domain;

import fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.CareEventMapper;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.OwnerMapper;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.domain.model.Bonsai;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.domain.model.CareEvent;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.domain.model.Owner;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.exposition.dto.BonsaiDTO;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.exposition.dto.CareEventDto;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.exposition.dto.OwnerDTO;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.repository.OwnerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OwnerService {
    private final OwnerRepository ownerRepository;

    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public List<OwnerDTO> findAll() {
        List<Owner> ownerEntities = ownerRepository.findAll();

        return OwnerMapper.mapModelsToDtosOwner(ownerEntities);

    }

    public Owner create(Owner owner) {
        return ownerRepository.create(owner);
    }

    public Owner findById(UUID id) {
        return ownerRepository.findById(id);
    }


    public List<BonsaiDTO> findAllBonsais(UUID id) {
        Owner owner = ownerRepository.findById(id);
        return OwnerMapper.mapModelsToDtosBonsai(owner.getBonsais());
    }


    public void transferBonsai(UUID owner_id, UUID bonsai_id, UUID newOwnerId) {
        Owner owner = ownerRepository.findById(owner_id);
        Owner newOwner = ownerRepository.findById(newOwnerId);
        Bonsai bonsai = owner.getBonsai(bonsai_id);
        ownerRepository.updateBonsaiOwner(newOwner.getId(), bonsai.getId());
    }

    public void addBonsais(UUID owner_id, List<UUID> uuids) {
        Owner owner = ownerRepository.findById(owner_id);
        ownerRepository.addBonsais(owner, uuids);
    }

    public List<CareEventDto> findAllBonsaiEvents(UUID id) {
      return(CareEventMapper.mapModelsToDTOS(ownerRepository.findAllBonsaiEvents(id)));
    }
}
