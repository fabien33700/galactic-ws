package imie.tp.galactic.ws.model.unities.production;

import java.time.LocalDateTime;

import imie.tp.galactic.ws.model.general.Planet;
import imie.tp.galactic.ws.model.unities.ProductionUnity;

/**
 * Un chantier spatial
 * @author Fabien
 *
 */
public class SpatialShipyard extends ProductionUnity {

	/**
	 * {@inheritDoc}
	 */
	protected SpatialShipyard(int size, int health, Long productionDelay, LocalDateTime creationDate, int ironCost,
			int plutoniumCost, int goldCost, Planet planet) {
		super(size, health, productionDelay, creationDate, ironCost, plutoniumCost, goldCost, planet);
		
	}

}
