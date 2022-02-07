package fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.exposition;


import fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.OwnerMapper;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.domain.OwnerService;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.domain.model.Owner;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.exposition.dto.OwnerDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/owners")
public class OwnerController {
    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping
    public List<OwnerDTO> findAll(){
       return ownerService.findAll();
    }

    @PostMapping()
    public ResponseEntity<OwnerDTO> createOwner(@RequestBody OwnerDTO ownerDTO) throws URISyntaxException {
        Owner bonsaiToCreate = ownerService.create(OwnerMapper.mapDtoToModelOwner(ownerDTO));
        OwnerDTO createdBonsai = OwnerMapper.mapModelToDtoOwner(bonsaiToCreate);
        return ResponseEntity.created(new URI("")).body(createdBonsai);
    }

}
