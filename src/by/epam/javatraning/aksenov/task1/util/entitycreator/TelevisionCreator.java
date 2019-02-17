package by.epam.javatraning.aksenov.task1.util.entitycreator;

import by.epam.javatraning.aksenov.task1.model.entity.Equipment;
import by.epam.javatraning.aksenov.task1.model.entity.Television;

public class TelevisionCreator implements Creator<Double> {
    @Override
    public Equipment create(double price, double power, boolean selector, Double diagonal) {
        return new Television(price, power, selector, diagonal);
    }
}
