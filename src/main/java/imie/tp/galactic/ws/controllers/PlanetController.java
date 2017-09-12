package imie.tp.galactic.ws.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import imie.tp.galactic.ws.model.general.Planet;
import imie.tp.galactic.ws.services.PlanetService;
import imie.tp.galactic.ws.views.Views;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/planets")
public class PlanetController {

    @Autowired
    private PlanetService planetService;

    @GetMapping
    @JsonView(Views.ShowAllPlanets.class)
    public List<Planet> getAllPlanets() {
        return planetService.findAll();
    }
}
