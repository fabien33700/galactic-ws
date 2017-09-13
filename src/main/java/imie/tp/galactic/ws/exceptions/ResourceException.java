package imie.tp.galactic.ws.exceptions;

public abstract class ResourceException extends RuntimeException {
    protected ResourceException(String message) {
        super(message);
    }
}
