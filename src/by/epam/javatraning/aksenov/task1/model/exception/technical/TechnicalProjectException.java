package by.epam.javatraning.aksenov.task1.model.exception.technical;

import by.epam.javatraning.aksenov.task1.model.exception.EquipmentProjectException;

public class TechnicalProjectException extends EquipmentProjectException {
    public TechnicalProjectException() {
    }

    public TechnicalProjectException(String message) {
        super(message);
    }

    public TechnicalProjectException(String message, Throwable cause) {
        super(message, cause);
    }

    public TechnicalProjectException(Throwable cause) {
        super(cause);
    }
}
