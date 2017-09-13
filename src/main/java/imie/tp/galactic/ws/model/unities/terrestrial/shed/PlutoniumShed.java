package imie.tp.galactic.ws.model.unities.terrestrial.shed;

import java.time.LocalDateTime;

import imie.tp.galactic.ws.model.constants.GameConstants;
import imie.tp.galactic.ws.model.core.ResourceEnum;
import imie.tp.galactic.ws.model.general.Planet;
import imie.tp.galactic.ws.model.unities.terrestrial.StorageShed;

/**
 * Hangar à plutonium
 * @author Fabien
 *
 */
public class PlutoniumShed extends StorageShed {

	/**
	 * {@inheritDoc}
	 */
    public PlutoniumShed(Planet planet) {
		super(
				GameConstants.PlutoniumShed.SIZE,
				GameConstants.PlutoniumShed.HEALTH,
				GameConstants.PlutoniumShed.PRODUCT_DELAY,
				LocalDateTime.now(),
				GameConstants.PlutoniumShed.IRON_COST,
				GameConstants.PlutoniumShed.PLUTONIUM_COST,
				GameConstants.PlutoniumShed.GOLD_COST,
				planet,
				ResourceEnum.PLUTONIUM,
				GameConstants.PlutoniumShed.INIT_CAPACITY
			);
		this.name = "Hangar à plutonium";
	}

}