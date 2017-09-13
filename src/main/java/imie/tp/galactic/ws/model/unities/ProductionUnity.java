package imie.tp.galactic.ws.model.unities;

import java.time.LocalDateTime;

import imie.tp.galactic.ws.model.general.Planet;
import imie.tp.galactic.ws.model.general.Unity;

/**
 * Classe abstraite qui représente une unité de production
 * @author Fabien
 *
 */
public abstract class ProductionUnity extends Unity {

	private static final long serialVersionUID = 4247622680106824000L;

	/**
	 * {@inheritDoc}
	 */
	protected ProductionUnity(int size, int health, Long productionDelay, LocalDateTime creationDate, int ironCost,
			int plutoniumCost, int goldCost, Planet planet) {
		super(size, health, productionDelay, creationDate, ironCost, plutoniumCost, goldCost, planet);
	}
	
}
