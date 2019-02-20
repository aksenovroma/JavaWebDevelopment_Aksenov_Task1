package by.epam.javatraning.aksenov.task1.model.logic;

import by.epam.javatraning.aksenov.task1.model.entity.Equipment;
import by.epam.javatraning.aksenov.task1.model.entity.Home;

public class Calculator {
    public static double sumPowerOfDevices(Home home) {
        double sumPower = 0;

        if (home == null) {
            return sumPower;
        }

        if (home.getEquipment() == null) {
            return sumPower;
        }

        for (Equipment equipment : home.getEquipment()) {
            sumPower += equipment.getPower();
        }
        return sumPower;
    }

    public static double sumPowerOfOnDevices(Home home) {
        double sumPower = 0;

        if (home == null) {
            return sumPower;
        }

        if (home.getEquipment() == null) {
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
