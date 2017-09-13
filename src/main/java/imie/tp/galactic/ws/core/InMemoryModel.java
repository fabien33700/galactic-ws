package imie.tp.galactic.ws.core;

import imie.tp.galactic.ws.utils.FakeUtils;
import imie.tp.galactic.ws.utils.PlanetFaker;
import imie.tp.galactic.ws.model.general.Planet;
import imie.tp.galactic.ws.utils.UnityFaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class InMemoryModel {

    private static final Logger logger = LoggerFactory.getLogger(InMemoryModel.class);

    private List<Planet> universe;

    @PostConstruct
    public void init() {
        universe = new ArrayList<>();
        for (int i = 0; i < FakeUtils.randomInt(2, 8); i++) {
            Planet p = PlanetFaker.makePlanet();
            universe.add(p);

            for (int j = 0; j < FakeUtils.randomInt(1, 5); j++) {
                try {
                    p.getUnities().add(UnityFaker.makeUnity(p));
                } catch (ReflectiveOperationException e) {
                    logger.warn("Erreur création d'unité", e);
                }
            }
        }
    }

    public List<Planet> getUniverse() {
        return universe;
    }
}
