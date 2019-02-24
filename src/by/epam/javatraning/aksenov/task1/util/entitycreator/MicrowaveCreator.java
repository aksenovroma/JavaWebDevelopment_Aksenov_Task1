package by.epam.javatraning.aksenov.task1.util.entitycreator;

import by.epam.javatraning.aksenov.task1.model.entity.Equipment;
import by.epam.javatraning.aksenov.task1.model.entity.Microwave;

/**
 * @author aksenov
 * @version 1.0
 */
public class MicrowaveCreator implements Creator<Double> {
    /**
     * Method create Microwave class object
     * @return Microwave class object
     */
    @Override
    public Equipment create(double price, double power, boolean selector, Double volume) {
        return new Microwave(price, power, selector, volume);
    }
}
