package imie.tp.galactic.ws.model.unities.terrestrial;

import java.time.LocalDateTime;

import imie.tp.galactic.ws.model.behaviour.Attacker;
import imie.tp.galactic.ws.model.general.Planet;
import imie.tp.galactic.ws.model.unities.TerrestrialUnity;

public class MissilesLauncher extends TerrestrialUnity implements Attacker {

	protected MissilesLauncher(int size, int health, Long productionDelay, LocalDateTime creationDate, int ironCost,
			int plutoniumCost, int goldCost, Planet planet) {
		super(size, health, productionDelay, creationDate, ironCost, plutoniumCost, goldCost, planet);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getAttack() {
		// TODO Auto-generated method stub
		return 0;
	}



}
