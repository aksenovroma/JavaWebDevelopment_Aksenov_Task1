package by.epam.javatraning.aksenov.task1.util.entitycreator;

import by.epam.javatraning.aksenov.task1.model.entity.Equipment;
import by.epam.javatraning.aksenov.task1.model.entity.Home;

/**
 * @author aksenov
 * @version 1.0
 */
public class HomeCreator {
    /**
     *
     * @param equipment - array of Equipment class objects
     * @return Home class object
     */
    public static Home create(Equipment[] equipment) {
        if (equipment == null) {
            return null;
        }

        return new Home(equipment);
    }
}
