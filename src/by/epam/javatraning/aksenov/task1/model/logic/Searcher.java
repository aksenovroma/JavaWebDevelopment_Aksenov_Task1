package by.epam.javatraning.aksenov.task1.model.logic;

import by.epam.javatraning.aksenov.task1.model.entity.Equipment;
import by.epam.javatraning.aksenov.task1.model.entity.Home;

/**
 * @author aksenov
 * @version 1.0
 *
 * Action-class works with information from class Home
 * Searcher seeks information according to different characteristics
 */

public class Searcher {
    /**
     *
     * @param home - Home class object
     * @param key - the value we want to find equipment
     * @return index of equipment with power == key
     */
    public static int findIndexOfEquipmentByPower(Home home, double key) {
        if (home == null || home.getEquipment() == null) {
            return -1;
        }

        Equipment[] equipment = home.getEquipment();

        for (int i = 0; i < equipment.length; i++){
            if (equipment[i].getPower() == key) {
                return i;
            }
        }
        return -1;
    }

    /**
     *
     * @param home - Home class object
     * @param key - the value we want to find equipment
     * @return index of equipment with price == key
     */
    public static int findIndexOfEquipmentByPrice(Home home, double key) {
        if (home == null || home.getEquipment() == null) {
            return -1;
        }

        Equipment[] equipment = home.getEquipment();

        for (int i = 0; i < equipment.length; i++){
            if (equipment[i].getPrice() == key) {
                return i;
            }
        }
        return -1;
    }

    /**
     *
     * @param home - Home class object
     * @return equipment with max price
     */
    public static Equipment findMaxPriceEquipment(Home home) {
        if (home == null || home.getEquipment() == null) {
            return null;
        }

        Equipment[] equipment = home.getEquipment();

        if (equipment == null || equipment.length == 0) {
            return null;
        }

        Equipment maxPriceEquipment = equipment[0];

        for (Equipment anEquipment : equipment) {
            if (maxPriceEquipment.getPrice() < anEquipment.getPrice()) {
                maxPriceEquipment = anEquipment;
            }
        }
        return maxPriceEquipment;
    }

    /**
     *
     * @param home - Home class object
     * @return equipment with min price
     */
    public static Equipment findMinPriceEquipment(Home home) {
        if (home == null || home.getEquipment() == null) {
            return null;
        }

        Equipment[] equipment = home.getEquipment();

        if (equipment == null || equipment.length == 0) {
            return null;
        }

        Equipment minPriceEquipment = equipment[0];

        for (Equipment anEquipment : equipment) {
            if (minPriceEquipment.getPrice() > anEquipment.getPrice()) {
                minPriceEquipment = anEquipment;
            }
        }
        return minPriceEquipment;
    }

    /**
     *
     * @param home - Home class object
     * @return equipment with max power
     */
    public static Equipment findMaxPowerEquipment(Home home) {
        if (home == null || home.getEquipment() == null) {
            return null;
        }

        Equipment[] equipment = home.getEquipment();

        if (equipment == null || equipment.length == 0) {
            return null;
        }

        Equipment maxPowerEquipment = equipment[0];

        for (Equipment anEquipment : equipment) {
            if (maxPowerEquipment.getPower() < anEquipment.getPower()) {
                maxPowerEquipment = anEquipment;
            }
        }
        return maxPowerEquipment;
    }

    /**
     *
     * @param home - Home class object
     * @return equipment with min power
     */
    public static Equipment findMinPowerEquipment(Home home) {
        if (home == null || home.getEquipment() == null) {
            return null;
        }

        Equipment[] equipment = home.getEquipment();

        if (equipment == null || equipment.length == 0) {
            return null;
        }

        Equipment minPowerEquipment = equipment[0];

        for (Equipment anEquipment : equipment) {
            if (minPowerEquipment.getPower() > anEquipment.getPower()) {
                minPowerEquipment = anEquipment;
            }
        }
        return minPowerEquipment;
    }
}