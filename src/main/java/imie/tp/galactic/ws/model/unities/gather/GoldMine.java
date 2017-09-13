package imie.tp.galactic.ws.model.unities.gather;

import imie.tp.galactic.ws.model.constants.GameConstants;
import imie.tp.galactic.ws.model.enums.ResourceEnum;
import imie.tp.galactic.ws.model.general.Planet;
import imie.tp.galactic.ws.model.unities.GatherUnity;

import java.time.LocalDateTime;

public class GoldMine extends GatherUnity {

	public GoldMine(Planet planet) {
		super(
				GameConstants.GoldMine.SIZE,
				GameConstants.GoldMine.HEALTH,
				GameConstants.GoldMine.PRODUCT_DELAY,
				LocalDateTime.now(),
				GameConstants.GoldMine.IRON_COST,
				GameConstants.GoldMine.PLUTONIUM_COST,
				GameConstants.GoldMine.GOLD_COST,
				planet,
				ResourceEnum.GOLD,
				GameConstants.GoldMine.INIT_CAPACITY
			);
		this.name = "Mine d'or";
	}

}
