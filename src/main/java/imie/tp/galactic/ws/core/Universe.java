package imie.tp.galactic.ws.core;

import imie.tp.galactic.ws.model.general.Planet;
import imie.tp.galactic.ws.model.general.Player;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Universe implements Serializable, GameLoopComponent {

    private Set<Planet> planets;

    private Set<Player> players;

    private long lastTimestamp = System.currentTimeMillis();

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

    public long getLastTimestamp() {
        return lastTimestamp;
    }

    @Override
    public void tick(float ratio) {
        lastTimestamp = System.currentTimeMillis();
    }
}