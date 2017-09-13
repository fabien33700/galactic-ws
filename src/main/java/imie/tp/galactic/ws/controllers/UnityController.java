package imie.tp.galactic.ws.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import imie.tp.galactic.ws.model.general.Unity;
import imie.tp.galactic.ws.resources.UnityCreationRequest;
import imie.tp.galactic.ws.services.UnityService;
import imie.tp.galactic.ws.views.Views;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/planet/{id}/unities")
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

    @PutMapping
    public ResponseEntity createUnityOnPlanet(
            @PathVariable("id") Long planetId,
            @RequestBody UnityCreationRequest request) {
        unityService.createUnityOnPlanet(planetId, request.getUnityType());
        return ResponseEntity.ok().build();
    }
}
