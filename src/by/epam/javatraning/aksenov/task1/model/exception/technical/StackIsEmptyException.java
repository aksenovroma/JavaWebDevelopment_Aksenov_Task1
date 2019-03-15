package by.epam.javatraning.aksenov.task1.model.exception.technical;

public class StackIsEmptyException extends TechnicalProjectException {
    public StackIsEmptyException() {
    }

    public StackIsEmptyException(String message) {
        super(message);
    }

    public StackIsEmptyException(String message, Throwable cause) {
        super(message, cause);
    }

    public StackIsEmptyException(Throwable exception) {
        super(exception);
    }
}
