package by.epam.javatraning.aksenov.task1.model.exception;

public class EquipmentPriceWrongException extends WrongArgumentException {
    public EquipmentPriceWrongException() {
    }

    public EquipmentPriceWrongException(String message) {
        super(message);
    }
}
