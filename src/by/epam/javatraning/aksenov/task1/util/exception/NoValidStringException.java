package by.epam.javatraning.aksenov.task1.util.exception;

public class NoValidStringException extends Exception {

    public NoValidStringException() {
    }

    public NoValidStringException(String message) {
        super(message);
    }

    public NoValidStringException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoValidStringException(Throwable cause) {
        super(cause);
    }
}
