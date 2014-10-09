package metrolink.core.services.exceptions;

/**
 * Created by Scott Meyer on 10/6/14.
 */
public class StopDoesNotExistException extends RuntimeException {
    public StopDoesNotExistException() {
    }

    public StopDoesNotExistException(String message) {
        super(message);
    }

    public StopDoesNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public StopDoesNotExistException(Throwable cause) {
        super(cause);
    }

}
