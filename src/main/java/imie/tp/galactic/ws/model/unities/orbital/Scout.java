package imie.tp.galactic.ws.model.unities.orbital;

import imie.tp.galactic.ws.model.constants.GameConstants;
import imie.tp.galactic.ws.model.general.Planet;
import imie.tp.galactic.ws.model.unities.OrbitalUnity;

import java.time.LocalDateTime;

public class Scout extends OrbitalUnity {

	private static final long serialVersionUID = -1097822128454272077L;

	public Scout(Planet planet) {
		super(
				GameConstants.Scout.SIZE,
				GameConstants.Scout.HEALTH,
				GameConstants.Scout.PRODUCT_DELAY,
				LocalDateTime.now(),
				GameConstants.Scout.IRON_COST,
				GameConstants.Scout.PLUTONIUM_COST,
				GameConstants.Scout.GOLD_COST,
				planet,
				GameConstants.Scout.BASE_SPEED
		);
		this.name = "Scout";
	}

}
