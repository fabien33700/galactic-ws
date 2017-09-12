package imie.tp.galactic.ws.services;

import imie.tp.galactic.ws.core.InMemoryModel;
import imie.tp.galactic.ws.model.general.Planet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanetService {

    @Autowired
    private InMemoryModel inMemoryModel;

    public List<Planet> findAll() {
        return inMemoryModel.getUniverse();
    }
}
