package imie.tp.galactic.ws.model.unities;

import imie.tp.galactic.ws.core.GameLoopComponent;
import imie.tp.galactic.ws.model.constants.GameConstants;
import imie.tp.galactic.ws.model.enums.ResourceEnum;
import imie.tp.galactic.ws.model.enums.UnityTypeEnum;
import imie.tp.galactic.ws.model.general.Planet;
import imie.tp.galactic.ws.model.general.Unity;

import java.time.LocalDateTime;

/**
 * Classe abstraite représentant une unité de collecte
 * @author Fabien
 *
 */
public abstract class GatherUnity extends Unity implements GameLoopComponent {

	private static final long serialVersionUID = 8441395969571686095L;
	/**
	 * Type de ressource récoltée
	 */
	protected ResourceEnum extractedResource;
	
	/**
	 * Capacité de production en ressource par minute
	 */
	protected float productionCapacity;

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

	public boolean notStorable() {
		switch (extractedResource) {
			case GOLD: return planet.getAvailableGold() > planet.getTotalGoldStorage();
			case IRON: return planet.getAvailableIron() > planet.getTotalIronStorage();
			case PLUTONIUM: return planet.getAvailablePlutonium() > planet.getTotalPlutoniumStorage();
		}
		return false;
	}

	protected GatherUnity(int size, int health, Long productionDelay, LocalDateTime creationDate, int ironCost,
			int plutoniumCost, int goldCost, Planet planet, ResourceEnum extractedResource, float productionCapacity) {
		super(size, health, productionDelay, creationDate, ironCost, plutoniumCost, goldCost, planet);
		this.extractedResource = extractedResource;
		this.productionCapacity = productionCapacity;
	}

	public ResourceEnum getExtractedResource() {
		return extractedResource;
	}

	protected boolean canExtract() {
		return !isDrained() && !notStorable() && !isBuilding();
	}
}
