package by.epam.javatraning.aksenov.task1.util.entitycreator;

import by.epam.javatraning.aksenov.task1.model.entity.Equipment;
import by.epam.javatraning.aksenov.task1.model.entity.Microwave;

public class MicrowaveCreator implements Creator<Double> {
    @Override
    public Equipment create(double price, double power, boolean selector, Double volume) {
        return new Microwave(price, power, selector, volume);
    }
}
