package imie.tp.galactic.ws.controllers;

import imie.tp.galactic.ws.model.general.UnityType;
import imie.tp.galactic.ws.services.UnityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/unities/types")
public class UnityController {

    @Autowired
    private UnityTypeService unityTypeService;

    @GetMapping
    public Set<UnityType> getAllUnitiesTypes() {
        return unityTypeService.getUnityTypes();
    }
}
