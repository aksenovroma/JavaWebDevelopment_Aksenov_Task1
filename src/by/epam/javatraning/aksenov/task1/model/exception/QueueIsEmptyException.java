package by.epam.javatraning.aksenov.task1.model.exception;

public class QueueIsEmptyException extends TechnicalProjectException {
    public QueueIsEmptyException() {
    }

    public QueueIsEmptyException(String message) {
        super(message);
    }
}
