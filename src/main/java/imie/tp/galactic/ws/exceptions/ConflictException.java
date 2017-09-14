package imie.tp.galactic.ws.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public abstract class ConflictException extends ResourceException {
    protected ConflictException(String message) {
        super(message);
    }
}
