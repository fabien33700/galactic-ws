package imie.tp.galactic.ws.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import imie.tp.galactic.ws.model.general.Unity;
import imie.tp.galactic.ws.resources.UnityCreationRequest;
import imie.tp.galactic.ws.services.model.UnityService;
import imie.tp.galactic.ws.views.Views;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/planets/{id}/unities")
public class UnityController {

    private final UnityService unityService;

    @Autowired
    public UnityController(UnityService unityService) {
        this.unityService = unityService;
    }

    @GetMapping
    @JsonView(Views.Public.class)
    public List<Unity> getAllUnitiesOnPlanet(@PathVariable("id") Long planetId) {
        return unityService.findAllOnPlanet(planetId);
    }

    @GetMapping("/building")
    @JsonView(Views.Unity.class)
    public List<Unity> getAllBuildingUnitiesOnPlanet(@PathVariable("id") Long planetId) {
        return unityService.findAllBuildingOnPlanet(planetId);
    }

    @PutMapping
    public ResponseEntity createUnityOnPlanet(
            @PathVariable("id") Long planetId,
            @RequestBody UnityCreationRequest request) {
        long id = unityService.createUnityOnPlanet(planetId, request.getUnityType());

        if (id > 0L) {
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(id)
                    .toUri();

            return ResponseEntity.created(location).build();
        } else {
            return ResponseEntity.noContent().build();
        }
    }
}
