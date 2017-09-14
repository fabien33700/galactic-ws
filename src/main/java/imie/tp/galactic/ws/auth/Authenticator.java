package imie.tp.galactic.ws.auth;

import javax.servlet.http.HttpServletRequest;

public interface Authenticator {
    boolean checkAuth(HttpServletRequest req);
}
