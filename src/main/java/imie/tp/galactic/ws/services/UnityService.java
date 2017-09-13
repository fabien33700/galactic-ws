package imie.tp.galactic.ws.services;

import imie.tp.galactic.ws.core.InMemoryModel;
import imie.tp.galactic.ws.exceptions.InternalServerException;
import imie.tp.galactic.ws.model.enums.UnityTypeEnum;
import imie.tp.galactic.ws.model.general.Planet;
import imie.tp.galactic.ws.model.general.Unity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnityService implements ResourceService {

    private final PlanetService planetService;
    private final InMemoryModel inMemoryModel;

    @Autowired
    public UnityService(PlanetService planetService, InMemoryModel inMemoryModel) {
        this.planetService = planetService;
        this.inMemoryModel = inMemoryModel;
    }

    public List<Unity> findAllOnPlanet(Long planetId) {
        return planetService.findById(planetId).getUnities();
    }

    public void createUnityOnPlanet(Long planetId, UnityTypeEnum resource) {
        Planet p = planetService.findById(planetId);
        Unity u;
        try {
            u = resource.getClazz()
                    .getDeclaredConstructor(Planet.class)
                    .newInstance(p);

        } catch (ReflectiveOperationException e) {
            throw new InternalServerException(e);
        }

        p.getUnities().add(u);
        save();
    }

    @Override
    public InMemoryModel getModel() {
        return inMemoryModel;
    }
}
