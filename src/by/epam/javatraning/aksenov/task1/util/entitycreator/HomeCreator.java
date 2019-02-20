package by.epam.javatraning.aksenov.task1.util.entitycreator;

import by.epam.javatraning.aksenov.task1.model.entity.Equipment;
import by.epam.javatraning.aksenov.task1.model.entity.Home;

public class HomeCreator {
    public static Home create(Equipment[] equipment) {
        if (equipment == null) {
            return null;
        }

        return new Home(equipment);
    }
}
