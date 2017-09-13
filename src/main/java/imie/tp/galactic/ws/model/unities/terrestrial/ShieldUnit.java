package imie.tp.galactic.ws.model.unities.terrestrial;

import java.time.LocalDateTime;

import imie.tp.galactic.ws.model.constants.GameConstants;
import imie.tp.galactic.ws.model.general.Planet;
import imie.tp.galactic.ws.model.unities.TerrestrialUnity;

public class ShieldUnit extends TerrestrialUnity {

	private static final long serialVersionUID = 7958694901175536496L;

	public ShieldUnit(Planet planet) {
		super(
				GameConstants.ShieldUnit.SIZE,
				GameConstants.ShieldUnit.HEALTH,
				GameConstants.ShieldUnit.PRODUCT_DELAY,
				LocalDateTime.now(),
				GameConstants.ShieldUnit.IRON_COST,
				GameConstants.ShieldUnit.PLUTONIUM_COST,
				GameConstants.ShieldUnit.GOLD_COST,
				planet
		);
		this.name = "Producteur de champ de force";
	}


}
