package hu.iit.uni.miskolc.model.exceptions;

public class InvalidGenderException extends Exception {
    public InvalidGenderException() {
    }

    public InvalidGenderException(String message) {
        super(message);
    }

    public InvalidGenderException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidGenderException(Throwable cause) {
        super(cause);
    }

    public InvalidGenderException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
