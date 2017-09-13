package imie.tp.galactic.ws.model.unities.orbital;

import java.time.LocalDateTime;

import imie.tp.galactic.ws.model.behaviour.Attacker;
import imie.tp.galactic.ws.model.constants.GameConstants;
import imie.tp.galactic.ws.model.general.Planet;
import imie.tp.galactic.ws.model.unities.OrbitalUnity;

public class Fighter extends OrbitalUnity implements Attacker {

	private int attack = 0;

	public Fighter(Planet planet) {
		super(
				GameConstants.Fighter.SIZE,
				GameConstants.Fighter.HEALTH,
				GameConstants.Fighter.PRODUCT_DELAY,
				LocalDateTime.now(),
				GameConstants.Fighter.IRON_COST,
				GameConstants.Fighter.PLUTONIUM_COST,
				GameConstants.Fighter.GOLD_COST,
				planet,
				GameConstants.Fighter.BASE_SPEED
		);
		this.name = "Chasseur";
		this.attack = GameConstants.Fighter.BASE_ATTACK;
	}

	@Override
	public int getAttack() {
		return attack;
	}

}
