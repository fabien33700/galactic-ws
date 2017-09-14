package imie.tp.galactic.ws.model.general;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;
import imie.tp.galactic.ws.model.identity.Identifiable;
import imie.tp.galactic.ws.views.Views;

public class Planet extends Identifiable implements Comparable<Planet> {

	private static final long serialVersionUID = -1108069485048680486L;
	/**
	 * Coordonnée X de la planète dans l'univers
	 */
    @JsonView(Views.Public.class)
	private int coordX;
	
	/**
	 * Coordonnée Y de la planète dans l'univers
	 */
    @JsonView(Views.Public.class)
	private int coordY;
	
	/**
	 * Espace orbital disponible 
	 */
    @JsonView(Views.Public.class)
	private int orbitalFreeSpace;
	
	/**
	 * Espace terrestre disponible
	 */
    @JsonView(Views.Public.class)
	private int groundFreeSpace;
	
	/**
	 * Fer disponible
	 */
    @JsonView(Views.Public.class)
	private int availableIron;
	
	/**
	 * Plutonium disponible
	 */
    @JsonView(Views.Public.class)
	private int availablePlutonium;
	
	/**
	 * Or disponible
	 */
    @JsonView(Views.Public.class)
	private int availableGold;
	
	/**
	 * Stock de fer de la planète
	 */
	private int stockIron;
	
	/**
	 * Stock de plutonium de la planète
	 */
	private int stockPlutonium;
	
	/**
	 * Stock d'or de la planète
	 */
	private int stockGold;
	
	/**
	 * Nom de la planète
	 */
    @JsonView(Views.Public.class)
	private String name;
	
	/**
	 * Liste des unités construites sur la planète
     */
    @JsonView({Views.ShowOnePlanet.class})
	private List<Unity> unities;
	
	/**
	 * Propriétaire (joueur) de la planète
	 */
    @JsonView(Views.Planet.class)
	private Player owner;
	

	public Planet(int coordX, int coordY, int orbitalFreeSpace, int groundFreeSpace, int availableIron,
			int availablePlutonium, int availableGold, int stockIron, int stockPlutonium, int stockGold, String name,
			List<Unity> unities, Player owner) {
		super();
		this.coordX = coordX;
		this.coordY = coordY;
		this.orbitalFreeSpace = orbitalFreeSpace;
		this.groundFreeSpace = groundFreeSpace;
		this.availableIron = availableIron;
		this.availablePlutonium = availablePlutonium;
		this.availableGold = availableGold;
		this.stockIron = stockIron;
		this.stockPlutonium = stockPlutonium;
		this.stockGold = stockGold;
		this.name = name;
		this.unities = unities;
		this.owner = owner;
	}

	public Planet() {
		super();
	}

	public int getCoordX() {
		return coordX;
	}

	public void setCoordX(int coordX) {
		this.coordX = coordX;
	}

	public int getCoordY() {
		return coordY;
	}

	public void setCoordY(int coordY) {
		this.coordY = coordY;
	}

	public int getOrbitalFreeSpace() {
		return orbitalFreeSpace;
	}

	public void setOrbitalFreeSpace(int orbitalFreeSpace) {
		this.orbitalFreeSpace = orbitalFreeSpace;
	}

	public int getGroundFreeSpace() {
		return groundFreeSpace;
	}

	public void setGroundFreeSpace(int groundFreeSpace) {
		this.groundFreeSpace = groundFreeSpace;
	}

	public int getAvailableIron() {
		return availableIron;
	}

	public void setAvailableIron(int availableIron) {
		this.availableIron = availableIron;
	}

	public int getAvailablePlutonium() {
		return availablePlutonium;
	}

	public void setAvailablePlutonium(int availablePlutonium) {
		this.availablePlutonium = availablePlutonium;
	}

	public int getAvailableGold() {
		return availableGold;
	}

	public void setAvailableGold(int availableGold) {
		this.availableGold = availableGold;
	}

	public int getStockIron() {
		return stockIron;
	}

	public void setStockIron(int stockIron) {
		this.stockIron = stockIron;
	}

	public int getStockPlutonium() {
		return stockPlutonium;
	}

	public void setStockPlutonium(int stockPlutonium) {
		this.stockPlutonium = stockPlutonium;
	}

	public int getStockGold() {
		return stockGold;
	}

	public void setStockGold(int stockGold) {
		this.stockGold = stockGold;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Unity> getUnities() {
		return unities;
	}

	public void setUnities(List<Unity> unities) {
		this.unities = unities;
	}

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

	@Override
	public int compareTo(Planet o) {
		return getId().compareTo(o.getId());
	}
}
