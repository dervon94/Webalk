package hu.iit.uni.miskolc.service.exceptions;

public class ExistingIdNumberException extends  Exception {

    public ExistingIdNumberException() {
    }

    public ExistingIdNumberException(String message) {
        super(message);
    }

    public ExistingIdNumberException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExistingIdNumberException(Throwable cause) {
        super(cause);
    }

    public ExistingIdNumberException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
