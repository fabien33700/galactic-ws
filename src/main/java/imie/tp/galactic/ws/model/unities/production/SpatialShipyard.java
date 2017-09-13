package imie.tp.galactic.ws.model.unities.production;

import java.time.LocalDateTime;

import imie.tp.galactic.ws.model.constants.GameConstants;
import imie.tp.galactic.ws.model.general.Planet;
import imie.tp.galactic.ws.model.unities.ProductionUnity;

/**
 * Un chantier spatial
 * @author Fabien
 *
 */
public class SpatialShipyard extends ProductionUnity {

	private static final long serialVersionUID = -6009788203431612297L;

	/**
	 * {@inheritDoc}
	 */
    public SpatialShipyard(Planet planet) {
		super(
				GameConstants.SpatialShipyard.SIZE,
				GameConstants.SpatialShipyard.HEALTH,
				GameConstants.SpatialShipyard.PRODUCT_DELAY,
				LocalDateTime.now(),
				GameConstants.SpatialShipyard.IRON_COST,
				GameConstants.SpatialShipyard.PLUTONIUM_COST,
				GameConstants.SpatialShipyard.GOLD_COST,
				planet
		);
		this.name = "Chantier spatial";
	}

}
