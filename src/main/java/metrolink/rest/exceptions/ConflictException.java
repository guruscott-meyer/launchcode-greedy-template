package metrolink.rest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Scott Meyer on 10/6/14.
 */
@ResponseStatus(value= HttpStatus.CONFLICT)
public class ConflictException extends RuntimeException{
    public ConflictException() {
    }

    public ConflictException(String message) {
        super(message);
    }

    public ConflictException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConflictException(Throwable cause) {
        super(cause);
    }
}
