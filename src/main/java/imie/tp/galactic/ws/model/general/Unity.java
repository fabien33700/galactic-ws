package imie.tp.galactic.ws.model.general;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import imie.tp.galactic.ws.model.constants.GameConstants;
import imie.tp.galactic.ws.model.identity.Identifiable;
import imie.tp.galactic.ws.serializers.DateDeserializer;
import imie.tp.galactic.ws.serializers.DateSerializer;
import imie.tp.galactic.ws.views.Views;

/**
 * Classe abstraite représentant une unité
 * @author Fabien
 *
 */

public abstract class Unity extends Identifiable {

	private static final long serialVersionUID = 6000849228361180483L;
	/**
	 * Le nom du type d'unité
	 */
	@JsonView(Views.UnityType.class)
	protected String name;
	
	/**
	 * Le niveau de l'unité
	 */
	protected int level = GameConstants.INIT_LEVEL;
	
	/**
	 * La taille de l'unité
	 */
	@JsonView(Views.Public.class)
	protected int size;
	
	/**
	 * Les points de vie de l'unité
	 */
	@JsonView(Views.Public.class)
	protected int health;
	
	/**
	 * Le temps de construction de l'unité (en secondes)
	 */
	protected Long productionDelay;
	
	/**
	 * Date de début de construction de l'unité
	 */
	@JsonView(Views.Public.class)
	@JsonSerialize(using = DateSerializer.class)
	@JsonDeserialize(using = DateDeserializer.class)
	protected LocalDateTime creationDate;
	
	/**
	 * Coût de l'unité en fer
	 */
	protected int ironCost;
	
	/**
	 * Coût de l'unité en plutonium
	 */
	protected int plutoniumCost;
	
	/**
	 * Coût de l'unité en or
	 */
	protected int goldCost;
	
	/**
	 * La planète sur laquelle est construite l'unité
	 */
	@JsonView({Views.ShowOneUnity.class})
	protected Planet planet;
	
	/**
	 * Indique si l'unité est en construction
	 * @return
	 */
	@JsonView(Views.Public.class)
	@JsonGetter(value = "building")
	public boolean isBuilding() {
		return creationDate
				.plusSeconds(productionDelay)
				.isAfter(LocalDateTime.now());
	}

	/**
	 * Constructeur complet
	 * @param size
	 * @param health
	 * @param productionDelay
	 * @param creationDate
	 * @param ironCost
	 * @param plutoniumCost
	 * @param goldCost
	 * @param planet
	 */
	protected Unity(int size, int health, Long productionDelay, LocalDateTime creationDate, int ironCost,
			int plutoniumCost, int goldCost, Planet planet) {
		super();
		this.size = size;
		this.health = health;
		this.productionDelay = productionDelay;
		this.creationDate = creationDate;
		this.ironCost = ironCost;
		this.plutoniumCost = plutoniumCost;
		this.goldCost = goldCost;
		this.planet = planet;
		this.name = "";
	}

	@JsonGetter("type")
	@JsonView(Views.Public.class)
	public String getType() {
		return this.getClass().getSimpleName();
	}

	public String getName() {
		return name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public Long getProductionDelay() {
		return productionDelay;
	}

	public void setProductionDelay(Long productionDelay) {
		this.productionDelay = productionDelay;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public int getIronCost() {
		return ironCost;
	}

	public void setIronCost(int ironCost) {
		this.ironCost = ironCost;
	}

	public int getPlutoniumCost() {
		return plutoniumCost;
	}

	public void setPlutoniumCost(int plutoniumCost) {
		this.plutoniumCost = plutoniumCost;
	}

	public int getGoldCost() {
		return goldCost;
	}

	public void setGoldCost(int goldCost) {
		this.goldCost = goldCost;
	}

	public Planet getPlanet() {
		return planet;
	}

	public void setPlanet(Planet planet) {
		this.planet = planet;
	}

}
