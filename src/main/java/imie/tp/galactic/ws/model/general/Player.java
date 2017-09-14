package imie.tp.galactic.ws.model.general;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import imie.tp.galactic.ws.model.identity.Identifiable;
import imie.tp.galactic.ws.views.Views;

public class Player extends Identifiable {

	private static final long serialVersionUID = 1563736634107946033L;
	@JsonView(Views.Public.class)
	private String pseudo;

	@JsonIgnore
	private String hashPass;

	@JsonView(Views.Player.class)
	private Set<Planet> planets;
	
	public Player() {
		super();
		planets = new HashSet<>();

	}

	public Player(String pseudo) {
		this();
		this.pseudo = pseudo;
	}

	public Player(String pseudo, String hashPass) {
		this();
		this.pseudo = pseudo;
		this.hashPass = hashPass;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getHashPass() {
		return hashPass;
	}

	public void setHashPass(String hashPass) {
		this.hashPass = hashPass;
	}

	public Set<Planet> getPlanets() {
		return planets;
	}

	public void setPlanets(Set<Planet> planets) {
		this.planets = planets;
	}
	
	

}
