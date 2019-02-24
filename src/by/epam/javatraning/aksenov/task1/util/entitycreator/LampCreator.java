package by.epam.javatraning.aksenov.task1.util.entitycreator;

import by.epam.javatraning.aksenov.task1.model.entity.Equipment;
import by.epam.javatraning.aksenov.task1.model.entity.Lamp;

/**
 * @author aksenov
 * @version 1.0
 */
public class LampCreator implements Creator<Integer> {
    /**
     * Method create Lamp class object
     * @return Lamp class object
     */
    @Override
    public Equipment create(double price, double power, boolean selector, Integer lightbulb) {
        return new Lamp(price, power, selector, lightbulb);
    }
}
