package by.epam.javatraning.aksenov.task1.model.logic;

import by.epam.javatraning.aksenov.task1.model.entity.Equipment;
import by.epam.javatraning.aksenov.task1.model.entity.Home;

/**
 * @author aksenov
 * @version 1.0
 *
 * Action-class works with information from class Home
 * Сalculator makes calculations according to different characteristics
 */

public class Calculator {
    /**
     *
     * @param home - Home class object
     * @return sum of the powers of the devices in the house
     */
    public static double sumPowerOfDevices(Home home) {
        double sumPower = 0;

        if (home == null || home.getEquipment() == null) {
            return sumPower;
        }

        for (Equipment equipment : home.getEquipment()) {
            sumPower += equipment.getPower();
        }
        return sumPower;
    }

    /**
     *
     * @param home - Home class object
     * @return sum of the powers of the devices (that is ON) in the house
     */
    public static double sumPowerOfOnDevices(Home home) {
        double sumPower = 0;

        if (home == null || home.getEquipment() == null) {
            return sumPower;
        }

        for (Equipment electricity : home.getEquipment()) {
            if (electricity.isSelector()) {
                sumPower += electricity.getPower();
            }
        }
        return sumPower;
    }
}
