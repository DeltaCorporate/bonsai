package fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.exposition;


import fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.OwnerMapper;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.domain.OwnerService;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.domain.model.Owner;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.exposition.dto.BonsaiDTO;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.bonsai.exposition.dto.CareEventDto;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.exposition.dto.OwnerDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/owners")
public class OwnerController {
    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping
    public ResponseEntity<List<OwnerDTO>> findAll() {
        List<OwnerDTO> ownerDTOS = ownerService.findAll();
        return ResponseEntity.ok(ownerDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OwnerDTO> findById(@PathVariable UUID id) {
        OwnerDTO founded = OwnerMapper.mapModelToDtoOwner(ownerService.findById(id));
        return ResponseEntity.ok(founded);
    }

    @PostMapping()
    public ResponseEntity<OwnerDTO> createOwner(@RequestBody OwnerDTO ownerDTO) throws URISyntaxException {
        Owner bonsaiToCreate = ownerService.create(OwnerMapper.mapDtoToModelOwner(ownerDTO));
        OwnerDTO createdBonsai = OwnerMapper.mapModelToDtoOwner(bonsaiToCreate);
        return ResponseEntity.created(new URI("")).body(createdBonsai);
    }

    @GetMapping("/{id}/bonsais")
    public ResponseEntity<List<BonsaiDTO>> findAllBonsais(@PathVariable UUID id) {
        List<BonsaiDTO> bonsaiDTOS = ownerService.findAllBonsais(id);
        return ResponseEntity.ok(bonsaiDTOS);
    }

    @PostMapping("/owner/{owner_id}/bonsais/{bonsai_id}/transfer")
    public ResponseEntity<Void> transferBonsai(@PathVariable UUID owner_id, @PathVariable UUID bonsai_id, @RequestBody OwnerDTO ownerDTO) {
        ownerService.transferBonsai(owner_id, bonsai_id, ownerDTO.getId());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/owner/{owner_id}/bonsais")
    public ResponseEntity<Void> addBonsai(@PathVariable UUID owner_id, @RequestBody List<UUID> uuids) {
        ownerService.addBonsais(owner_id, uuids);
        return ResponseEntity.ok().build();
    }



}
