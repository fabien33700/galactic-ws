package imie.tp.galactic.ws.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalServerException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "Une erreur interne s'est produite sur le serveur !";

    public InternalServerException() {
        super(DEFAULT_MESSAGE);
    }
    public InternalServerException(String message) {
        super(message);
    }

    public InternalServerException(Throwable e) {
        super(DEFAULT_MESSAGE + " " + e.getMessage());
    }
}
