package fr.iutmontreuil.csid.monpetitbonsaiprivate.bonsai.repository;

import fr.iutmontreuil.csid.monpetitbonsaiprivate.bonsai.BonsaiMapper;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.bonsai.CareEventMapper;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.bonsai.domain.model.Bonsai;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.bonsai.domain.model.CareEvent;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.commons.persistence.BonsaiDao;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.commons.persistence.BonsaiEntity;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.commons.persistence.CareEventDao;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class BonsaiRepository {

    private final BonsaiDao bonsaiDao;
    private final CareEventDao careventDao;

    public BonsaiRepository(BonsaiDao bonsaiDao, CareEventDao careventDao) {
        this.bonsaiDao = bonsaiDao;
        this.careventDao = careventDao;
    }

    public Optional<Bonsai> findById(UUID uuid) {
        Optional<BonsaiEntity> entity = bonsaiDao.findById(uuid);
        return entity.map(BonsaiMapper::mapEntityToModel);
    }

    public List<Bonsai> findAll(String status) {
        List<BonsaiEntity> entities = new ArrayList<>();
        if(status == null){
            entities = bonsaiDao.findAll();
        } else{
            entities = bonsaiDao.findAllByStatus(status);
        }
        return BonsaiMapper.mapEntitiesToModels(entities);
    }

    public Bonsai create(Bonsai bonsai) {
        BonsaiEntity bonsaiToCreate = BonsaiMapper.mapModelToEntity(bonsai);
        BonsaiEntity savedBonsai = bonsaiDao.save(bonsaiToCreate);
        return BonsaiMapper.mapEntityToModel(savedBonsai);
    }


    public Bonsai update(Bonsai bonsai){
        BonsaiEntity bonsaiToUpdate = BonsaiMapper.mapModelToEntity(bonsai);
        BonsaiEntity savedBonsai = bonsaiDao.save(bonsaiToUpdate);
        return BonsaiMapper.mapEntityToModel(savedBonsai);
    }


    public void delete(UUID uuid) {
        bonsaiDao.deleteById(uuid);
    }

    public void changeStatus(Bonsai bonsai) {
        BonsaiEntity bonsaiTochangeStatus = BonsaiMapper.mapModelToEntity(bonsai);
        bonsaiDao.save(bonsaiTochangeStatus);
    }
    public List<CareEvent> findAllBonsaiEvents(UUID id) {
        return CareEventMapper.mapEntitiesToModels(careventDao.findByBonsai(id));
    }

}
