package imie.tp.galactic.ws.core;

import imie.tp.galactic.ws.model.general.Planet;
import imie.tp.galactic.ws.model.general.Player;
import imie.tp.galactic.ws.model.identity.IdentityCounter;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

public class Universe implements Serializable, Reinitializable {

    private Set<Planet> planets;

    private Set<Player> players;

    public Universe() {
        this.planets = new TreeSet<>();
        this.players = new TreeSet<>();
    }

    public Set<Planet> getPlanets() {
        return planets;
    }

    public void setPlanets(Set<Planet> planets) {
        this.planets = planets;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

    @Override
    public void reset() {
        planets.clear();
        players.clear();
        IdentityCounter.getInstance().reset();
    }
}