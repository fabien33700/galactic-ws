package imie.tp.galactic.ws.model.unities;

import java.time.LocalDateTime;

import imie.tp.galactic.ws.model.core.ResourceEnum;
import imie.tp.galactic.ws.model.general.Planet;
import imie.tp.galactic.ws.model.general.Unity;

/**
 * Classe abstraite repr�sentant une unit� de collecte
 * @author Fabien
 *
 */
public abstract class GatherUnity extends Unity {
	
	/**
	 * Type de ressource récoltée
	 */
	protected ResourceEnum extractedResource;
	
	/**
	 * Capacité de production en ressource par seconde
	 */
	protected double productionCapacity;

	/**
	 * Indique si la ressource extraite par l'unité est épuisée
	 * @return
	 */
	public boolean isDrained() {
		switch (extractedResource) {
			case GOLD: return planet.getStockGold() < 0;
			case IRON: return planet.getStockIron() < 0;
			case PLUTONIUM: return planet.getStockPlutonium() < 0;
		}
		return false;
	}

	protected GatherUnity(int size, int health, Long productionDelay, LocalDateTime creationDate, int ironCost,
			int plutoniumCost, int goldCost, Planet planet, ResourceEnum extractedResource, int productionCapacity) {
		super(size, health, productionDelay, creationDate, ironCost, plutoniumCost, goldCost, planet);
		this.extractedResource = extractedResource;
		this.productionCapacity = productionCapacity;
	}
}
