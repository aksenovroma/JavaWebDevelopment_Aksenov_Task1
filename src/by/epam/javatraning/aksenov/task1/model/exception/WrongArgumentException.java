package by.epam.javatraning.aksenov.task1.model.exception;

public class WrongArgumentException extends LogicProjectException {
    public WrongArgumentException() {
    }

    public WrongArgumentException(String message) {
        super(message);
    }
}
