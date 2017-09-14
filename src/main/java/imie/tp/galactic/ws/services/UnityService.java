package imie.tp.galactic.ws.services;

import imie.tp.galactic.ws.core.InMemoryModel;
import imie.tp.galactic.ws.exceptions.ImpossibleBuildException;
import imie.tp.galactic.ws.exceptions.InternalServerException;
import imie.tp.galactic.ws.model.enums.UnityTypeEnum;
import imie.tp.galactic.ws.model.general.Planet;
import imie.tp.galactic.ws.model.general.Unity;
import imie.tp.galactic.ws.model.general.UnityType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
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

    public List<Unity> findAllOnPlanet(HttpServletRequest req, Long planetId) {
        return planetService.findById(req, planetId).getUnities();
    }

    public Long createUnityOnPlanet(HttpServletRequest req, Long planetId, UnityTypeEnum resource) {
        Planet p = planetService.findById(req, planetId);

        Unity u;
        try {
            u = resource.getClazz()
                    .getDeclaredConstructor(Planet.class)
                    .newInstance(p);

        } catch (ReflectiveOperationException e) {
            throw new InternalServerException(e);
        }

        canBuildUnity(p, u);
        p.getUnities().add(u);
        updateResources(p, u);
        save();

        return u.getId();

    }

    private void updateResources(Planet planet, Unity unity) {
        planet.setAvailableGold(planet.getAvailableGold() - unity.getGoldCost());
        planet.setAvailableIron(planet.getAvailableIron() - unity.getIronCost());
        planet.setAvailablePlutonium(planet.getAvailablePlutonium() - unity.getPlutoniumCost());
    }

    private void canBuildUnity(Planet planet, Unity unity) throws ImpossibleBuildException {
        if (unity.getGoldCost() > planet.getAvailableGold()) {
            throw new ImpossibleBuildException("Vous n'avez pas assez d'or pour créer cette unité.");
        }

        if (unity.getIronCost() > planet.getAvailableIron()) {
            throw new ImpossibleBuildException("Vous n'avez pas assez de fer pour créer cette unité.");
        }

        if (unity.getPlutoniumCost() > planet.getAvailablePlutonium()) {
            throw new ImpossibleBuildException("Vous n'avez pas assez de plutonium pour créer cette unité.");
        }

        if (unity.isOrbital() && unity.getSize() > planet.getOrbitalFreeSpace()) {
            throw new ImpossibleBuildException("L'orbite de cette planète ne dispose plus d'assez d'espace pour accueillir cette unité.");
        }

        if (!unity.isOrbital() && unity.getSize() > planet.getGroundFreeSpace()) {
            throw new ImpossibleBuildException("Cette planète ne dispose plus d'assez d'espace au sol pour accueillir cette unité.");
        }
    }

    @Override
    public InMemoryModel getModel() {
        return inMemoryModel;
    }
}
