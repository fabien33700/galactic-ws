package imie.tp.galactic.ws.model.unities.gather;

import java.time.LocalDateTime;

import imie.tp.galactic.ws.model.constants.GameConstants;
import imie.tp.galactic.ws.model.enums.ResourceEnum;
import imie.tp.galactic.ws.model.general.Planet;
import imie.tp.galactic.ws.model.unities.GatherUnity;

public class PlutoniumFactory extends GatherUnity {

	private static final long serialVersionUID = -6285290832039127665L;

	public PlutoniumFactory(Planet planet) {
		super(
				GameConstants.PlutoniumFactory.SIZE,
				GameConstants.PlutoniumFactory.HEALTH,
				GameConstants.PlutoniumFactory.PRODUCT_DELAY,
				LocalDateTime.now(),
				GameConstants.PlutoniumFactory.IRON_COST,
				GameConstants.PlutoniumFactory.PLUTONIUM_COST,
				GameConstants.PlutoniumFactory.GOLD_COST,
				planet,
				ResourceEnum.PLUTONIUM,
				GameConstants.PlutoniumFactory.INIT_CAPACITY
			);
		this.name = "Usine de plutonium";
	}

}
