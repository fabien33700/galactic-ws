package imie.tp.galactic.ws.model.behaviour;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonView;
import imie.tp.galactic.ws.views.Views;

public interface Attacker {

	@JsonGetter("attack")
	@JsonView(Views.Public.class)
	int getAttack();

}
