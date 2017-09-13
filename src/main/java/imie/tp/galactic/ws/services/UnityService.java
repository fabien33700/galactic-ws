package imie.tp.galactic.ws.services;

import imie.tp.galactic.ws.core.InMemoryModel;
import imie.tp.galactic.ws.model.enums.UnityTypeEnum;
import imie.tp.galactic.ws.model.general.Unity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnityService {

    @Autowired
    private PlanetService planetService;

    public List<Unity> findAllOnPlanet(Long planetId) {
        return planetService.findById(planetId).getUnities();
    }

    public void createUnityOnPlanet(Long planetId, UnityTypeEnum resource) {

    }
}
