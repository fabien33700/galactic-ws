package imie.tp.galactic.ws.services;

import imie.tp.galactic.ws.core.InMemoryModel;
import imie.tp.galactic.ws.exceptions.ResourceNotFoundException;
import imie.tp.galactic.ws.model.general.Planet;
import imie.tp.galactic.ws.model.general.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

@Service
public class PlanetService implements ResourceService {

    private static final Logger logger = LoggerFactory.getLogger(PlanetService.class);

    private final LoginService loginService;
    private final InMemoryModel inMemoryModel;

    @Autowired
    public PlanetService(InMemoryModel inMemoryModel, LoginService loginService) {
        this.inMemoryModel = inMemoryModel;
        this.loginService = loginService;
    }

    public Set<Planet> findAll(HttpServletRequest req) {
        Player p = loginService.getRequestPlayer(req);

        if (p != null) {
            return inMemoryModel.getUniverse().getPlanets().stream()
                    .filter(pl -> pl.getOwner().equals(p))
                    .collect(Collectors.toSet());
        }

        return new TreeSet<>();
    }

    public Planet findById(HttpServletRequest req, final Long id) throws ResourceNotFoundException{
        Player requestPlayer = loginService.getRequestPlayer(req);
        return inMemoryModel.getUniverse().getPlanets().stream()
                .filter(p -> p.getId().equals(id))
                .filter(p -> p.getOwner().equals(requestPlayer))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Override
    public InMemoryModel getModel() {
        return inMemoryModel;
    }
}
