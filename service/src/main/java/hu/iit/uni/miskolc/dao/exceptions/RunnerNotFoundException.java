package hu.iit.uni.miskolc.dao.exceptions;

public class RunnerNotFoundException extends Exception {
        public RunnerNotFoundException() {
        }

        public RunnerNotFoundException(String message) {
            super(message);
        }

        public RunnerNotFoundException(String message, Throwable cause) {
            super(message, cause);
        }

        public RunnerNotFoundException(Throwable cause) {
            super(cause);
        }

        public RunnerNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
            super(message, cause, enableSuppression, writableStackTrace);
        }
    }

