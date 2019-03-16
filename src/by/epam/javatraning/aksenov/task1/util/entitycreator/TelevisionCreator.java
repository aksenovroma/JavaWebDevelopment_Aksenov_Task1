package by.epam.javatraning.aksenov.task1.util.entitycreator;

import by.epam.javatraning.aksenov.task1.model.entity.Equipment;
import by.epam.javatraning.aksenov.task1.model.entity.Television;

/**
 * @author aksenov
 * @version 2.0
 */
public class TelevisionCreator implements Creator {
    /**
     * Method create Television class object
     * @return Television class object
     */
    @Override
    public Equipment create() {
        return new Television();
    }
}
