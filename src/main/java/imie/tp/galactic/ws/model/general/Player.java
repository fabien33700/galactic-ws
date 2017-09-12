package imie.tp.galactic.ws.model.general;

import java.util.List;

import imie.tp.galactic.ws.model.core.Identifiable;

public class Player extends Identifiable {
	
	private Long id;
	
	private String pseudo;
	private String hashPass;
	
	private List<Planet> planets;
	
	public Player() {
		super();
	}

	public Player(String pseudo) {
		this.pseudo = pseudo;
	}

	public Long getId() {
		return id;
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

	public List<Planet> getPlanets() {
		return planets;
	}

	public void setPlanets(List<Planet> planets) {
		this.planets = planets;
	}
	
	

}
