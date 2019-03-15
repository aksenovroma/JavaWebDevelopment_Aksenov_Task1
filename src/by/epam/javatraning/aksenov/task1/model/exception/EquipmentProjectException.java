package by.epam.javatraning.aksenov.task1.model.exception;

public class EquipmentProjectException extends Exception {
    public EquipmentProjectException() {
    }

    public EquipmentProjectException(String message) {
        super(message);
    }

    public EquipmentProjectException(String message, Throwable cause) {
        super(message, cause);
    }

    public EquipmentProjectException(Throwable cause) {
        super(cause);
    }
}
