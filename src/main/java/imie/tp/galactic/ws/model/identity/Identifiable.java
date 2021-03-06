package imie.tp.galactic.ws.model.identity;

import com.fasterxml.jackson.annotation.JsonView;
import imie.tp.galactic.ws.views.Views;

import java.io.Serializable;

public abstract class Identifiable implements Serializable, Comparable<Identifiable> {

    private static final long serialVersionUID = -4826997475899993012L;
    private Long id = 0L;

	@JsonView(Views.Public.class)
	public Long getId() {
		return this.id;
	}
	
	protected Identifiable() {
		this.id = IdentifierGenerator.getInstance().registerObject(this);
	}

	@Override
	public int compareTo(Identifiable o) {
		return getId().compareTo(o.getId());
	}
}
