package imie.tp.galactic.ws.model.unities.orbital;

import java.time.LocalDateTime;

import imie.tp.galactic.ws.model.behaviour.Attacker;
import imie.tp.galactic.ws.model.general.Planet;
import imie.tp.galactic.ws.model.unities.OrbitalUnity;

public class Fighter extends OrbitalUnity implements Attacker {


	protected Fighter(int size, int health, Long productionDelay, LocalDateTime creationDate, int ironCost,
			int plutoniumCost, int goldCost, Planet planet, int speed) {
		super(size, health, productionDelay, creationDate, ironCost, plutoniumCost, goldCost, planet, speed);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getAttack() {
		// TODO Auto-generated method stub
		return 0;
	}

}
