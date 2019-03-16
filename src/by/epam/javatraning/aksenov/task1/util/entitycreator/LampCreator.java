package by.epam.javatraning.aksenov.task1.util.entitycreator;

import by.epam.javatraning.aksenov.task1.model.entity.Equipment;
import by.epam.javatraning.aksenov.task1.model.entity.Lamp;

/**
 * @author aksenov
 * @version 2.0
 */
public class LampCreator implements Creator {
    /**
     * Method create Lamp class object
     * @return Lamp class object
     */
    @Override
    public Equipment create() {
        return new Lamp();
    }
}
