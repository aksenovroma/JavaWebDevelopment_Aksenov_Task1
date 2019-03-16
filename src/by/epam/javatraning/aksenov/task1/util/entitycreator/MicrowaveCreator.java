package by.epam.javatraning.aksenov.task1.util.entitycreator;

import by.epam.javatraning.aksenov.task1.model.entity.Equipment;
import by.epam.javatraning.aksenov.task1.model.entity.Microwave;

/**
 * @author aksenov
 * @version 2.0
 */
public class MicrowaveCreator implements Creator {
    /**
     * Method create Microwave class object
     * @return Microwave class object
     */
    @Override
    public Equipment create() {
        return new Microwave();
    }
}
