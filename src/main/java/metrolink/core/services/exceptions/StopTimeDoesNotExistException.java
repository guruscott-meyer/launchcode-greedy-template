package metrolink.core.services.exceptions;

/**
 * Created by Scott Meyer on 10/6/14.
 */
public class StopTimeDoesNotExistException extends RuntimeException{
    public StopTimeDoesNotExistException() {
    }

    public StopTimeDoesNotExistException(String message) {
        super(message);
    }

    public StopTimeDoesNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public StopTimeDoesNotExistException(Throwable cause) {
        super(cause);
    }
}
