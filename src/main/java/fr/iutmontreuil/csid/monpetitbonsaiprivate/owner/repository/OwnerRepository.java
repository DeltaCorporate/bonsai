package fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.repository;

import fr.iutmontreuil.csid.monpetitbonsaiprivate.commons.persistence.OwnerDao;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.commons.persistence.OwnerEntity;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.OwnerMapper;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.domain.model.Owner;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OwnerRepository {

    private final OwnerDao ownerDao;

    public OwnerRepository(OwnerDao ownerDao) {
        this.ownerDao = ownerDao;
    }

    public  Owner create(Owner owner) {
        OwnerEntity ownerToCreate = OwnerMapper.mapModelToEntityOwner(owner);
        OwnerEntity savedOwner = ownerDao.save(ownerToCreate);
        return OwnerMapper.mapEntityToModelOwner(savedOwner);
    }

    public List<Owner> findAll() {
        return OwnerMapper.mapEntitiesToModelsOwner(ownerDao.findAll());
    }
}
