package metrolink.core.services.exceptions;

/**
 * Created by Scott Meyer on 10/6/14.
 */
public class StopTripDoesNotExistException extends RuntimeException{
    public StopTripDoesNotExistException() {
    }

    public StopTripDoesNotExistException(String message) {
        super(message);
    }

    public StopTripDoesNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public StopTripDoesNotExistException(Throwable cause) {
        super(cause);
    }
}
