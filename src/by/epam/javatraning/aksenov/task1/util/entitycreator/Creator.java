package by.epam.javatraning.aksenov.task1.util.entitycreator;

import by.epam.javatraning.aksenov.task1.model.entity.Equipment;

/**
 * @author aksenov
 * @version 1.0
 * @param <T> - param that can be different for various classes
 */
public interface Creator<T> {
    Equipment create(double price, double power, boolean selector, T someField);
}
