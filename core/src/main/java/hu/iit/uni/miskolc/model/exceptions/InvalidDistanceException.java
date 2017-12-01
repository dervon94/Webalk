package hu.iit.uni.miskolc.model.exceptions;

public class InvalidDistanceException extends Exception {
    public InvalidDistanceException() {
    }

    public InvalidDistanceException(String message) {
        super(message);
    }

    public InvalidDistanceException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidDistanceException(Throwable cause) {
        super(cause);
    }

    public InvalidDistanceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
