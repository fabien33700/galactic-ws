package imie.tp.galactic.ws.model.unities;

import java.time.LocalDateTime;

import imie.tp.galactic.ws.model.general.Planet;
import imie.tp.galactic.ws.model.general.Unity;

/**
 * Classe abstraite représentant une unité terrestre
 * @author Fabien
 *
 */
public abstract class TerrestrialUnity extends Unity {

	/**
	 * {@inheritDoc}
	 */
	protected TerrestrialUnity(int size, int health, Long productionDelay, LocalDateTime creationDate, int ironCost,
			int plutoniumCost, int goldCost, Planet planet) {
		super(size, health, productionDelay, creationDate, ironCost, plutoniumCost, goldCost, planet);
	}

}
