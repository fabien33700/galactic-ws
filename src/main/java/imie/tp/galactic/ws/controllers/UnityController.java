package imie.tp.galactic.ws.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import imie.tp.galactic.ws.model.general.Unity;
import imie.tp.galactic.ws.resources.UnityCreationRequest;
import imie.tp.galactic.ws.services.UnityService;
import imie.tp.galactic.ws.views.Views;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/planet/{id}/unities")
public class UnityController {

    @Autowired
    private UnityService unityService;


    @GetMapping
    @JsonView(Views.Public.class)
    public List<Unity> getAllUnitiesOnPlanet(@PathVariable("id") Long planetId) {
        return unityService.findAllOnPlanet(planetId);
    }

    @PostMapping
    public ResponseEntity createUnityOnPlanet(
            @PathVariable("id") Long planetId,
            @RequestBody UnityCreationRequest request) {
        unityService.createUnityOnPlanet(planetId, request.getUnityType());
        return null;
    }
}
