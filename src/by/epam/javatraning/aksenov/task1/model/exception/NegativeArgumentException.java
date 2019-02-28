package by.epam.javatraning.aksenov.task1.model.exception;

public class NegativeArgumentException extends RuntimeException {
    public NegativeArgumentException() {
    }

    public NegativeArgumentException(String message) {
        super(message);
    }
}
