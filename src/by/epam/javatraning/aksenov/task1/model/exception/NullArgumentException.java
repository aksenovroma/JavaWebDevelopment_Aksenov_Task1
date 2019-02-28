package by.epam.javatraning.aksenov.task1.model.exception;

public class NullArgumentException extends RuntimeException {
    public NullArgumentException() {
    }

    public NullArgumentException(String message) {
        super(message);
    }
}
