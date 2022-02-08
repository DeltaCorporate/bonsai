package fr.iutmontreuil.csid.monpetitbonsaiprivate.bonsai.exposition;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.bonsai.BonsaiMapper;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.bonsai.domain.BonsaiService;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.bonsai.domain.model.Bonsai;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.bonsai.exposition.dto.BonsaiDTO;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.bonsai.exposition.dto.CareEventDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/bonsais")
public class BonsaiController {

    private final BonsaiService bonsaiService;

    public BonsaiController(BonsaiService bonsaiService) {
        this.bonsaiService = bonsaiService;
    }

    @GetMapping
    public List<BonsaiDTO> findAllBonsais(@RequestParam(required = false,name = "status") String status) {
        List<Bonsai> bonsais = bonsaiService.findAll(status);
        return BonsaiMapper.mapModelsToDtos(bonsais);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<BonsaiDTO> findBonsaiById(@PathVariable("uuid") UUID uuid){
        Optional<Bonsai> bonsaiToFind = bonsaiService.findById(uuid);

        BonsaiDTO bonsaiDTO = BonsaiMapper.mapModelToDto(bonsaiToFind.get());
        return ResponseEntity.ok(bonsaiDTO);

    }

    @PostMapping()
    public ResponseEntity<BonsaiDTO> createBonsai(@RequestBody BonsaiDTO bonsaiDTO) throws URISyntaxException {
        Bonsai bonsaiToCreate = bonsaiService.create(BonsaiMapper.mapDtoToModel(bonsaiDTO));
        BonsaiDTO createdBonsai = BonsaiMapper.mapModelToDto(bonsaiToCreate);
        return ResponseEntity.created(new URI("")).body(createdBonsai);
    }

    @PatchMapping("/{uuid}")
    public ResponseEntity<BonsaiDTO> updateBonsai(@RequestBody BonsaiDTO bonsaiDTO,@PathVariable("uuid") UUID uuid) {
        Bonsai bonsaiToUpdate = bonsaiService.update(BonsaiMapper.mapDtoToModel(bonsaiDTO),uuid);
        BonsaiDTO updatedBonsai = BonsaiMapper.mapModelToDto(bonsaiToUpdate);
        return ResponseEntity.ok(updatedBonsai);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> deleteBonsai(@PathVariable("uuid") UUID uuid) {
        bonsaiService.delete(uuid);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/{uuid}")
    public ResponseEntity<Void> changeStatus(@RequestBody BonsaiDTO bonsaiDTO,@PathVariable("uuid") UUID uuid) {
        bonsaiService.changeStatus(bonsaiDTO,uuid);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/care-events")
    public ResponseEntity<List<CareEventDto>> allEventsOfBonsai(@PathVariable UUID id, @RequestParam(required = false,name = "type") String type) {
        List<CareEventDto> bonsaiEvents = bonsaiService.findAllBonsaiEvents(id, type);
        return ResponseEntity.ok(bonsaiEvents);
    }

   @PostMapping("/care-events/{id}")
    public ResponseEntity<CareEventDto> createEvent(@RequestBody CareEventDto careEventDto, @PathVariable UUID id) throws URISyntaxException {
        CareEventDto careEventCreated = bonsaiService.createEvent(careEventDto, id);
        return ResponseEntity.created(new URI("")).body(careEventCreated);
    }


    @DeleteMapping("/{id}/care-events/{event-id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable(name = "id") UUID bonsaiID,@PathVariable(name ="event-id" ) UUID eventID){
        bonsaiService.deleteEvent(bonsaiID,eventID);
        return ResponseEntity.ok().build();
    }

}
