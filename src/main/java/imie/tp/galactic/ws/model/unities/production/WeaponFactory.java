package imie.tp.galactic.ws.model.unities.production;

import java.time.LocalDateTime;

import imie.tp.galactic.ws.model.general.Planet;
import imie.tp.galactic.ws.model.unities.ProductionUnity;

/**
 * Usine d'armement
 * @author Fabien
 *
 */
public class WeaponFactory extends ProductionUnity {

	/**
	 * {@inheritDoc}
	 */
	protected WeaponFactory(int size, int health, Long productionDelay, LocalDateTime creationDate, int ironCost,
			int plutoniumCost, int goldCost, Planet planet) {
		super(size, health, productionDelay, creationDate, ironCost, plutoniumCost, goldCost, planet);
	}

}
