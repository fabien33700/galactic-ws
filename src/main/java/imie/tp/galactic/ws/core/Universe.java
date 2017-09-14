package imie.tp.galactic.ws.core;

import imie.tp.galactic.ws.model.general.Planet;
import imie.tp.galactic.ws.model.general.Player;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Universe implements Serializable {

    private Set<Planet> planets;

    private Set<Player> players;

    public Universe() {
        this.planets = new HashSet<>();
        this.players = new HashSet<>();
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
}