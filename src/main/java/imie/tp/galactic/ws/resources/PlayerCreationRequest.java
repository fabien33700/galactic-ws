package imie.tp.galactic.ws.resources;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;

public class PlayerCreationRequest {

    @NotEmpty(message = "Vous devez renseigner le pseudo")
    private String pseudo;

    @NotEmpty(message = "Vous devez envoyer un mot de passe")
    @Pattern(
            regexp = "[\\w-+*!#@&=]{6,12}",
            flags = Pattern.Flag.CASE_INSENSITIVE,
            message = "Le mot de passe doit comporter de 6 à 12 caractères alphanumériques et symboles suivant :" +
                    " -, +, !, #, !, @, &, ="
    )
    private String hashPass;

    public PlayerCreationRequest() {}

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getHashPass() {
        return hashPass;
    }

    public void setHashPass(String hashPass) {
        this.hashPass = hashPass;
    }
}
