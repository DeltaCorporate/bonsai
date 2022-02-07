package fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.repository;

import fr.iutmontreuil.csid.monpetitbonsaiprivate.commons.persistence.BonsaiDao;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.commons.persistence.OwnerDao;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.commons.persistence.OwnerEntity;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.OwnerMapper;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.domain.model.Owner;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class OwnerRepository {

    private final OwnerDao ownerDao;
    private final BonsaiDao bonsaiDao;

    public OwnerRepository(OwnerDao ownerDao,BonsaiDao bonsaiDao) {
        this.ownerDao = ownerDao;
        this.bonsaiDao = bonsaiDao;
    }

    public  Owner create(Owner owner) {
        OwnerEntity ownerToCreate = OwnerMapper.mapModelToEntityOwner(owner);
        OwnerEntity savedOwner = ownerDao.save(ownerToCreate);
        return OwnerMapper.mapEntityToModelOwner(savedOwner);
    }

    public List<Owner> findAll() {
        return OwnerMapper.mapEntitiesToModelsOwner(ownerDao.findAll());
    }

    public Owner findById(UUID id) {
        return OwnerMapper.mapEntityToModelOwner(ownerDao.findById(id).get());
    }

    public void update(Owner owner) {
        OwnerEntity ownerToUpdate = OwnerMapper.mapModelToEntityOwner(owner);
        ownerDao.save(ownerToUpdate);
    }

    public void updateBonsaiOwner(UUID ownerId, UUID bonsaiId) {
        bonsaiDao.updateBonsai(ownerId, bonsaiId);
    }
}
