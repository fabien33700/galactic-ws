package imie.tp.galactic.ws.core;

import imie.tp.galactic.ws.core.dev.PlanetFaker;
import imie.tp.galactic.ws.model.general.Planet;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class InMemoryModel {

    private List<Planet> universe;

    @PostConstruct
    public void init() {
        universe = new ArrayList<>();
        Random rd = new Random();
        int n = rd.nextInt(3) + 2;
        for (int i = 0; i < n; i++) {
            universe.add(PlanetFaker.makePlanet());
        }
    }

    public List<Planet> getUniverse() {
        return universe;
    }
}
