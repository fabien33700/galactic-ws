package imie.tp.galactic.ws.model.identity;

import imie.tp.galactic.ws.core.Reinitializable;

import java.util.HashMap;

public class IdentityCounter implements Reinitializable {
	
	private HashMap<Long, Identifiable> identifiables;

	private static IdentityCounter instance = null;
	
	private Long getLastId() {
		return identifiables.keySet()
			.stream().mapToLong(Long::valueOf)
			.max().orElse(0);
	}
	
	private IdentityCounter() {
		this.identifiables = new HashMap<>();
	}

	public HashMap<Long, Identifiable> getIdentifiables() {
		return identifiables;
	}

    public static IdentityCounter getInstance() {
	    if (instance == null) {
	        instance = new IdentityCounter();
        }
        return instance;
    }

    Long registerObject(Identifiable identifiable) {
		Long id = getLastId() + 1;
		this.identifiables.put(id, identifiable);

		return id;
	}


	@Override
	public void reset() {
		identifiables.clear();
	}
}
