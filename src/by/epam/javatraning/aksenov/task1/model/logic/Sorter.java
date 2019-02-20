package by.epam.javatraning.aksenov.task1.model.logic;

import by.epam.javatraning.aksenov.task1.model.entity.Equipment;
import by.epam.javatraning.aksenov.task1.model.entity.Home;

public class Sorter {
    public static void bubbleSortByPower(Home home) {
        if (home == null || home.getEquipment() == null) {
            return;
        }

        Equipment[] equipment = home.getEquipment();

        if (equipment == null || equipment.length == 0) {
            return;
        }

        for (int i = equipment.length - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if (equipment[j].getPower() < equipment[j + 1].getPower()) {
                    replace(equipment, j);
                }
            }
        }
    }

    public static void replace(Object[] array, int j) {
        Object temp = array[j];
        array[j] = array[j + 1];
        array[j + 1] = temp;
    }
}
