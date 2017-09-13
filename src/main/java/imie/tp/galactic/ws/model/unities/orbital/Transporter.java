package imie.tp.galactic.ws.model.unities.orbital;

import java.time.LocalDateTime;

import imie.tp.galactic.ws.model.constants.GameConstants;
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

	public Transporter(Planet planet) {
		super(
				GameConstants.Transporter.SIZE,
				GameConstants.Transporter.HEALTH,
				GameConstants.Transporter.PRODUCT_DELAY,
				LocalDateTime.now(),
				GameConstants.Transporter.IRON_COST,
				GameConstants.Transporter.PLUTONIUM_COST,
				GameConstants.Transporter.GOLD_COST,
				planet,
				GameConstants.Transporter.BASE_SPEED
		);
		this.goldVolume = GameConstants.Transporter.GOLD_VOLUME;
		this.plutoniumVolume = GameConstants.Transporter.PLUT_VOLUME;
		this.ironVolume = GameConstants.Transporter.IRON_VOLUME;
		this.name = "Transporteur";
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
