package imie.tp.galactic.ws.model.identity;

import java.util.HashMap;

public class IdentifierGenerator {
	
	private HashMap<Long, Identifiable> identifiables;

	private static IdentifierGenerator instance = null;
	
	private Long getLastId() {
		return identifiables.keySet()
			.stream().mapToLong(Long::valueOf)
			.max().orElse(0);
	}
	
	private IdentifierGenerator() {
		this.identifiables = new HashMap<>();
	}

	public HashMap<Long, Identifiable> getIdentifiables() {
		return identifiables;
	}

    static IdentifierGenerator getInstance() {
	    if (instance == null) {
	        instance = new IdentifierGenerator();
        }
        return instance;
    }

    Long registerObject(Identifiable identifiable) {
		Long id = getLastId() + 1;
		this.identifiables.put(id, identifiable);

		return id;
	}
	
	

}
