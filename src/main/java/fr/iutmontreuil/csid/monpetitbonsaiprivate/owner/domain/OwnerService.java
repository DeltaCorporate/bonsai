package fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.domain;

import fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.OwnerMapper;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.domain.model.Owner;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.exposition.dto.OwnerDTO;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.repository.OwnerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

}
