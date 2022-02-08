package fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.repository;

import fr.iutmontreuil.csid.monpetitbonsaiprivate.commons.persistence.BonsaiDao;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.commons.persistence.BonsaiEntity;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.commons.persistence.CareEventDao;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.commons.persistence.OwnerDao;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.commons.persistence.OwnerEntity;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.bonsai.CareEventMapper;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.OwnerMapper;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.bonsai.domain.model.CareEvent;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.domain.model.Owner;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class OwnerRepository {

    private final OwnerDao ownerDao;
    private final BonsaiDao bonsaiDao;
    CareEventDao careventDao;

    public OwnerRepository(OwnerDao ownerDao, BonsaiDao bonsaiDao, CareEventDao careventDao) {
        this.ownerDao = ownerDao;
        this.bonsaiDao = bonsaiDao;
        this.careventDao = careventDao;
    }


    public Owner create(Owner owner) {
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

    public void addBonsais(Owner owner, List<UUID> uuids) {
        for (UUID uuid : uuids) {
            BonsaiEntity bonsai = bonsaiDao.findById(uuid).orElse(new BonsaiEntity());

            if (bonsai.getOwnerEntity() == null) {
                bonsaiDao.updateBonsai(owner.getId(), uuid);
            }
        }
    }


}
