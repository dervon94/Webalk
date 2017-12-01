package hu.iit.uni.miskolc.dao.exceptions;

public class RunnerAlreadyExistException extends Exception {
    public RunnerAlreadyExistException() {
    }

    public RunnerAlreadyExistException(String message) {
        super(message);
    }

    public RunnerAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public RunnerAlreadyExistException(Throwable cause) {
        super(cause);
    }

    public RunnerAlreadyExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

