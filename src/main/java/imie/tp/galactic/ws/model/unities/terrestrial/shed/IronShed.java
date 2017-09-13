package imie.tp.galactic.ws.model.unities.terrestrial.shed;

import java.time.LocalDateTime;

import imie.tp.galactic.ws.model.constants.GameConstants;
import imie.tp.galactic.ws.model.enums.ResourceEnum;
import imie.tp.galactic.ws.model.general.Planet;
import imie.tp.galactic.ws.model.unities.terrestrial.StorageShed;

/**
 * Hangar à fer
 * @author Fabien
 *
 */
public class IronShed extends StorageShed {

	/**
	 * {@inheritDoc}
	 */
    public IronShed(Planet planet) {
		super(
				GameConstants.IronShed.SIZE,
				GameConstants.IronShed.HEALTH,
				GameConstants.IronShed.PRODUCT_DELAY,
				LocalDateTime.now(),
				GameConstants.IronShed.IRON_COST,
				GameConstants.IronShed.PLUTONIUM_COST,
				GameConstants.IronShed.GOLD_COST,
				planet,
				ResourceEnum.IRON,
				GameConstants.IronShed.INIT_CAPACITY
			);
		this.name = "Hangar à fer";
	}

}
