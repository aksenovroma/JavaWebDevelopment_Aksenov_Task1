package by.epam.javatraning.aksenov.task1.util.entitycreator;

import by.epam.javatraning.aksenov.task1.model.entity.Equipment;

public interface Creator<T> {
    Equipment create(double price, double power, boolean selector, T someField);
}
