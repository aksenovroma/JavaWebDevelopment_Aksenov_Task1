package by.epam.javatraning.aksenov.task1.model.logic;

import by.epam.javatraning.aksenov.task1.model.entity.Equipment;
import by.epam.javatraning.aksenov.task1.model.entity.Home;

/**
 * @author aksenov
 * @version 1.0
 *
 * Action-class works with information from class Home
 * Sorter sorts information according to different characteristics
 */

public class Sorter {
    /**
     * Method sorts information by power
     * @param home - Home class object
     */
    public static void bubbleSortByPower(Home home) {
        if (home == null || home.getEquipment() == null) {
            return;
        }

        Equipment[] equipment = home.getEquipment();

        if (equipment.length == 0) {
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

    /**
     *
     * @param array - array that we want to change
     * @param j - index of element that we wont replace forward
     */
    public static void replace(Object[] array, int j) {
        if (array == null || j < 0 || j >= array.length -1){
            return;
        }

        Object temp = array[j];
        array[j] = array[j + 1];
        array[j + 1] = temp;
    }
}
