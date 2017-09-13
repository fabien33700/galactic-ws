package imie.tp.galactic.ws.model.core;

import java.util.HashMap;

public class IdGenerator {
	
	private static IdGenerator instance = null;
	
	private HashMap<Long, Identifiable> identifiables;
	
	public Long getLastId() {
		return identifiables.keySet()
			.stream().mapToLong(Long::valueOf)
			.max().orElse(0);
	}
	
	private IdGenerator() {
		this.identifiables = new HashMap<>();
	}

	public HashMap<Long, Identifiable> getIdentifiables() {
		return identifiables;
	}
	
	public static IdGenerator getInstance() {
		if (instance == null) {
			instance = new IdGenerator();
		}
		
		return instance;
	}
	
	public Long registerObject(Identifiable identifiable) {
		Long id = getLastId() + 1;
		this.identifiables.put(id, identifiable);
		return id;
	}
	
	

}
