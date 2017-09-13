package imie.tp.galactic.ws.services;

import imie.tp.galactic.ws.core.InMemoryModel;
import imie.tp.galactic.ws.exceptions.ResourceNotFoundException;
import imie.tp.galactic.ws.model.general.Planet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanetService implements ResourceService {

    private static final Logger logger = LoggerFactory.getLogger(PlanetService.class);

    private final InMemoryModel inMemoryModel;

    @Autowired
    public PlanetService(InMemoryModel inMemoryModel) {
        this.inMemoryModel = inMemoryModel;
    }

    public List<Planet> findAll() {
        return inMemoryModel.getUniverse();
    }

    public Planet findById(final Long id) throws ResourceNotFoundException{
        logger.warn("{}", inMemoryModel);
        return inMemoryModel.getUniverse().stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Override
    public InMemoryModel getModel() {
        return inMemoryModel;
    }
}
