package by.epam.javatraning.aksenov.task1.model.exception;

public class StackIsEmptyException extends TechnicalProjectException {
    public StackIsEmptyException() {
    }

    public StackIsEmptyException(String message) {
        super(message);
    }
}
