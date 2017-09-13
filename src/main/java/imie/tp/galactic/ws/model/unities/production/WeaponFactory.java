package imie.tp.galactic.ws.model.unities.production;

import java.time.LocalDateTime;

import imie.tp.galactic.ws.model.constants.GameConstants;
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
    public WeaponFactory(Planet planet) {
		super(
				GameConstants.WeaponFactory.SIZE,
				GameConstants.WeaponFactory.HEALTH,
				GameConstants.WeaponFactory.PRODUCT_DELAY,
				LocalDateTime.now(),
				GameConstants.WeaponFactory.IRON_COST,
				GameConstants.WeaponFactory.PLUTONIUM_COST,
				GameConstants.WeaponFactory.GOLD_COST,
				planet
		);
		this.name = "Usine d'armement";
	}

}
