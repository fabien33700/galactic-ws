package imie.tp.galactic.ws.model.unities.orbital;

import java.time.LocalDateTime;

import imie.tp.galactic.ws.model.general.Planet;
import imie.tp.galactic.ws.model.unities.OrbitalUnity;

/**
 * Un transporteur
 * @author Fabien
 *
 */
public class Transporter extends OrbitalUnity {
	
	/**
	 * Le volume maximale d'or pouvant être embarqué
	 */
	private int goldVolume;
	
	/**
	 * Le volume maximale de plutonium pouvant être embarqué
	 */
	private int plutoniumVolume;
	
	/**
	 * Le volume maximale de fer pouvant être embarqué
	 */
	private int ironVolume;

	/**
	 * {@inheritDoc}
	 */
	protected Transporter(int size, int health, Long productionDelay, LocalDateTime creationDate, int ironCost,
			int plutoniumCost, int goldCost, Planet planet, int speed, int goldVolume, int plutoniumVolume,
			int ironVolume) {
		super(size, health, productionDelay, creationDate, ironCost, plutoniumCost, goldCost, planet, speed);
		this.goldVolume = goldVolume;
		this.plutoniumVolume = plutoniumVolume;
		this.ironVolume = ironVolume;
	}

	public int getGoldVolume() {
		return goldVolume;
	}

	public void setGoldVolume(int goldVolume) {
		this.goldVolume = goldVolume;
	}

	public int getPlutoniumVolume() {
		return plutoniumVolume;
	}

	public void setPlutoniumVolume(int plutoniumVolume) {
		this.plutoniumVolume = plutoniumVolume;
	}

	public int getIronVolume() {
		return ironVolume;
	}

	public void setIronVolume(int ironVolume) {
		this.ironVolume = ironVolume;
	}

}
