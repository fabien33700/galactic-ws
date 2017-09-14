package imie.tp.galactic.ws.model.unities;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonView;
import imie.tp.galactic.ws.model.general.Planet;
import imie.tp.galactic.ws.model.general.Unity;
import imie.tp.galactic.ws.services.TravelService;
import imie.tp.galactic.ws.views.Views;

public abstract class OrbitalUnity extends Unity {

	private static final long serialVersionUID = 8522474967754431758L;

	@JsonView(Views.Public.class)
	@JsonGetter("orbital")
	public boolean isOrbital() {
		return true;
	}
	/**
	 * La vitesse de déplacement de l'unité orbital
	 */
	protected int speed;

	/**
	 * La planète sur laquelle le vaisseau est stationné actuellement
	 */
	protected Planet position;
	
	/**
	 * La planète vers laquelle se dirige éventuellement le vaisseau
	 */
	protected Planet destination;
	
	/**
	 * La date/heure du départ du vaisseau
	 */
	protected LocalDateTime departureDatetime;
	
	/**
	 * {@inheritDoc}
	 */
	protected OrbitalUnity(int size, int health, Long productionDelay, LocalDateTime creationDate, int ironCost,
			int plutoniumCost, int goldCost, Planet planet, int speed) {
		super(size, health, productionDelay, creationDate, ironCost, plutoniumCost, goldCost, planet);
		this.speed = speed;
		// Au départ, le vaisseau est situé dans l'orbite de la planète d'origine
		this.position = planet;
	}
	
	/**
	 * Indique si l'unité orbitale est en train de voyager
	 * @return
	 */
	public boolean isTravelling() {
		return destination != null;
	}
	
	/**
	 * Obtient la date/heure d'arrivée sur la planète de destination si un voyage est en court
	 * @return
	 */
	public Optional<LocalDateTime> getArrivalDatetime() {
		return (isTravelling()) ?
				Optional.of(TravelService.computeArrivalDateTime(position, destination, departureDatetime)) :
				Optional.empty();
	}
	
	/**
	 * Obtient le temps de voyage restant
	 * @return
	 */
	public Optional<Long> getRemainingTravelTime() {
		return (isTravelling()) ?
				Optional.of(ChronoUnit.SECONDS.between(LocalDateTime.now(), getArrivalDatetime().get())) :
				Optional.empty();
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public Planet getPosition() {
		return position;
	}

	public void setPosition(Planet position) {
		this.position = position;
	}

	public Planet getDestination() {
		return destination;
	}

	public void setDestination(Planet destination) {
		this.destination = destination;
	}

	public LocalDateTime getDepartureDatetime() {
		return departureDatetime;
	}

	public void setDepartureDatetime(LocalDateTime departureDatetime) {
		this.departureDatetime = departureDatetime;
	}
	
	

}
