package imie.tp.galactic.ws.model.unities.terrestrial;

import java.time.LocalDateTime;

import imie.tp.galactic.ws.model.behaviour.Attacker;
import imie.tp.galactic.ws.model.constants.GameConstants;
import imie.tp.galactic.ws.model.general.Planet;
import imie.tp.galactic.ws.model.unities.TerrestrialUnity;

public class MissilesLauncher extends TerrestrialUnity implements Attacker {

	private static final long serialVersionUID = -5116999255937693824L;
	private int attack;

	public MissilesLauncher(Planet planet) {
		super(
				GameConstants.MissilesLauncher.SIZE,
				GameConstants.MissilesLauncher.HEALTH,
				GameConstants.MissilesLauncher.PRODUCT_DELAY,
				LocalDateTime.now(),
				GameConstants.MissilesLauncher.IRON_COST,
				GameConstants.MissilesLauncher.PLUTONIUM_COST,
				GameConstants.MissilesLauncher.GOLD_COST,
				planet
		);
		this.name = "Tourelles de missiles AA";
		this.attack = GameConstants.MissilesLauncher.BASE_ATTACK;
	}

	@Override
	public int getAttack() {
		return attack;
	}



}
