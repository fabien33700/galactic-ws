package imie.tp.galactic.ws.resources;

import org.hibernate.validator.constraints.NotEmpty;

public class LoginRequest {

    @NotEmpty
    private String pseudo;

    @NotEmpty
    private String hashPass;

    public LoginRequest() {}

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
