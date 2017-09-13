package imie.tp.galactic.ws.model.unities.orbital;

import java.time.LocalDateTime;

import imie.tp.galactic.ws.model.behaviour.Attacker;
import imie.tp.galactic.ws.model.constants.GameConstants;
import imie.tp.galactic.ws.model.general.Planet;
import imie.tp.galactic.ws.model.unities.OrbitalUnity;

public class Cruiser extends OrbitalUnity implements Attacker {

	private int attack = 0;

	public Cruiser(Planet planet) {
		super(
				GameConstants.Cruiser.SIZE,
				GameConstants.Cruiser.HEALTH,
				GameConstants.Cruiser.PRODUCT_DELAY,
				LocalDateTime.now(),
				GameConstants.Cruiser.IRON_COST,
				GameConstants.Cruiser.PLUTONIUM_COST,
				GameConstants.Cruiser.GOLD_COST,
				planet,
				GameConstants.Cruiser.BASE_SPEED
		);
		this.name = "Croiseur";
		this.attack = GameConstants.Cruiser.BASE_ATTACK;
	}

	@Override
	public int getAttack() {
		return attack;
	}

}
