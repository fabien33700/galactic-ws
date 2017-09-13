package imie.tp.galactic.ws.services;

import imie.tp.galactic.ws.core.InMemoryModel;
import imie.tp.galactic.ws.exceptions.ResourceNotFoundException;
import imie.tp.galactic.ws.model.general.Planet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlanetService {

    private static final Logger logger = LoggerFactory.getLogger(PlanetService.class);

    @Autowired
    private InMemoryModel inMemoryModel;

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
}
