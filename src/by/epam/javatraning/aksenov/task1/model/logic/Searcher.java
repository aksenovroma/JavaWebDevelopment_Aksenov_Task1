package by.epam.javatraning.aksenov.task1.model.logic;

import by.epam.javatraning.aksenov.task1.model.entity.Equipment;
import by.epam.javatraning.aksenov.task1.model.entity.Home;

public class Searcher {
    public static int findIndexOfEquipmentByPower(Home home, double key){
        if (home == null){
            return -1;
        }

        Equipment[] equipment = home.getEquipment();
        int index = 0;

        while (index < equipment.length){
            if (equipment[index].getPower() == key){
                return index;
            }
            index++;
        }
        return -1;
    }

    public static Equipment findMaxPriceEquipment(Home home){
        if (home == null){
            return null;
        }

        Equipment[] equipment = home.getEquipment();

        if (equipment == null){
            return null;
        }

        if (equipment.length == 0){
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

    public static Equipment findMinPriceEquipment(Home home){
        if (home == null){
            return null;
        }

        Equipment[] equipment = home.getEquipment();

        if (equipment == null){
            return null;
        }

        if (equipment.length == 0){
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

    public static Equipment findMaxPowerEquipment(Home home){
        if (home == null){
            return null;
        }

        Equipment[] equipment = home.getEquipment();

        if (equipment == null){
            return null;
        }

        if (equipment.length == 0){
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

    public static Equipment findMinPowerEquipment(Home home){
        if (home == null){
            return null;
        }

        Equipment[] equipment = home.getEquipment();

        if (equipment == null){
            return null;
        }

        if (equipment.length == 0){
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