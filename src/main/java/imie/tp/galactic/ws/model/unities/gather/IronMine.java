package imie.tp.galactic.ws.model.unities.gather;

import java.time.LocalDateTime;

import imie.tp.galactic.ws.model.constants.GameConstants;
import imie.tp.galactic.ws.model.enums.ResourceEnum;
import imie.tp.galactic.ws.model.general.Planet;
import imie.tp.galactic.ws.model.unities.GatherUnity;

public class IronMine extends GatherUnity {

	private static final long serialVersionUID = -4698530090523945335L;

	public IronMine(Planet planet) {
		
		super(
				GameConstants.IronMine.SIZE,
				GameConstants.IronMine.HEALTH,
				GameConstants.IronMine.PRODUCT_DELAY,
				LocalDateTime.now(),
				GameConstants.IronMine.IRON_COST,
				GameConstants.IronMine.PLUTONIUM_COST,
				GameConstants.IronMine.GOLD_COST,
				planet,
				ResourceEnum.IRON,
				GameConstants.IronMine.INIT_CAPACITY
			);
		this.name = "Mine de fer";
	}

}
