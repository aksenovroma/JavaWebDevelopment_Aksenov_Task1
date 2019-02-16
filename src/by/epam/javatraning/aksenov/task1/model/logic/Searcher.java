package by.epam.javatraning.aksenov.task1.model.logic;

import by.epam.javatraning.aksenov.task1.model.entity.Equipment;
import by.epam.javatraning.aksenov.task1.model.entity.Home;

public class Searcher {
    public static int findIndexOfDeviceByPower(Home home, double key){
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
}
