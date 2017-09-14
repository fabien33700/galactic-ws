package imie.tp.galactic.ws.services;

import imie.tp.galactic.ws.core.InMemoryModel;
import imie.tp.galactic.ws.model.general.Planet;
import imie.tp.galactic.ws.model.general.Player;
import imie.tp.galactic.ws.resources.PlayerCreationRequest;
import imie.tp.galactic.ws.utils.PlanetFaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PlayerService {

    @Autowired private InMemoryModel inMemoryModel;

    public Set<Player> findAll() {
        return inMemoryModel.getUniverse().getPlayers();
    }

    public Long createPlayer(PlayerCreationRequest request) {
        Player player = new Player(request.getPseudo(), request.getHashPass());
        Planet planet = PlanetFaker.makePlanet(player);
        player.getPlanets().add(planet);

        inMemoryModel.getUniverse().getPlayers().add(player);
        inMemoryModel.getUniverse().getPlanets().add(planet);

        return player.getId();
    }
}
