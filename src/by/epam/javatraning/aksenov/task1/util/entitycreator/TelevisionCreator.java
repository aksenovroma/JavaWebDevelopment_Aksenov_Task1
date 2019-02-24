package by.epam.javatraning.aksenov.task1.util.entitycreator;

import by.epam.javatraning.aksenov.task1.model.entity.Equipment;
import by.epam.javatraning.aksenov.task1.model.entity.Television;

/**
 * @author aksenov
 * @version 1.0
 */
public class TelevisionCreator implements Creator<Double> {
    /**
     * Method create Television class object
     * @return Television class object
     */
    @Override
    public Equipment create(double price, double power, boolean selector, Double diagonal) {
        return new Television(price, power, selector, diagonal);
    }
}
