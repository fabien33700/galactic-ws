package imie.tp.galactic.ws.model.unities.terrestrial;

import java.time.LocalDateTime;

import imie.tp.galactic.ws.model.enums.ResourceEnum;
import imie.tp.galactic.ws.model.general.Planet;
import imie.tp.galactic.ws.model.unities.TerrestrialUnity;

public abstract class StorageShed extends TerrestrialUnity {
	
	protected ResourceEnum storedResource;
	
	protected int storageCapacity;

	protected StorageShed(int size, int health, Long productionDelay, LocalDateTime creationDate, int ironCost,
			int plutoniumCost, int goldCost, Planet planet, ResourceEnum storedResource, int storageCapacity) {
		super(size, health, productionDelay, creationDate, ironCost, plutoniumCost, goldCost, planet);
		this.storedResource = storedResource;
		this.storageCapacity = storageCapacity;
	}


}
