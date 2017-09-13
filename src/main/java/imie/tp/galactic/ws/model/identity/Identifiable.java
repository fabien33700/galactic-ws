package imie.tp.galactic.ws.model.identity;

import com.fasterxml.jackson.annotation.JsonView;
import imie.tp.galactic.ws.views.Views;

import java.io.Serializable;

public abstract class Identifiable implements Serializable{

	private Long id = 0L;

	@JsonView(Views.Public.class)
	public Long getId() {
		return this.id;
	}
	
	protected Identifiable() {
		this.id = IdentifierGenerator.getInstance().registerObject(this);
	}

}
