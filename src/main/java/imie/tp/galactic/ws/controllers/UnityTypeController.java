package imie.tp.galactic.ws.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import imie.tp.galactic.ws.model.general.Unity;
import imie.tp.galactic.ws.model.general.UnityType;
import imie.tp.galactic.ws.services.UnityService;
import imie.tp.galactic.ws.services.UnityTypeService;
import imie.tp.galactic.ws.views.Views;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/unities/types")
public class UnityTypeController {

    @Autowired
    private UnityTypeService unityTypeService;

    @GetMapping
    public Set<UnityType> getAllUnitiesTypes() {
        return unityTypeService.getUnityTypes();
    }

}
