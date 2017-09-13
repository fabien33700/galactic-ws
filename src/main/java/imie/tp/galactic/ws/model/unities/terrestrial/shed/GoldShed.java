package imie.tp.galactic.ws.model.unities.terrestrial.shed;

import java.time.LocalDateTime;

import imie.tp.galactic.ws.model.constants.GameConstants;
import imie.tp.galactic.ws.model.core.ResourceEnum;
import imie.tp.galactic.ws.model.general.Planet;
import imie.tp.galactic.ws.model.unities.terrestrial.StorageShed;

/**
 * Hangar à or
 * @author Fabien
 *
 */
public class GoldShed extends StorageShed {

	/**
	 * {@inheritDoc}
	 */
    public GoldShed(Planet planet) {
		super(
				GameConstants.GoldShed.SIZE,
				GameConstants.GoldShed.HEALTH,
				GameConstants.GoldShed.PRODUCT_DELAY,
				LocalDateTime.now(),
				GameConstants.GoldShed.IRON_COST,
				GameConstants.GoldShed.PLUTONIUM_COST,
				GameConstants.GoldShed.GOLD_COST,
				planet,
				ResourceEnum.GOLD,
				GameConstants.GoldShed.INIT_CAPACITY
			);
		this.name = "Hangar à or";
	}

}
