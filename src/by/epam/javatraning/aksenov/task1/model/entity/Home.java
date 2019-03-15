package by.epam.javatraning.aksenov.task1.model.entity;

import by.epam.javatraning.aksenov.task1.model.exception.logic.HomeEquipmentWrongException;

import java.util.Arrays;

/**
 * @author aksenov
 * @version 1.0
 *
 * Entity class for storing information about electrical equipment in the house
 * Class storing data in equipment array
 * Class Home has methods for adding and removing equipment from house
 */

public class Home {
    private static final String NULL_POINTER_EXC = "argument can't be null";

    private Equipment[] equipment = new Equipment[0];

    public Home(Equipment... equipment) {
        if (equipment != null) {
            this.equipment = equipment;
        }
    }

    public Equipment[] getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment[] equipment) throws HomeEquipmentWrongException{
        if (equipment == null) {
            throw new HomeEquipmentWrongException(NULL_POINTER_EXC);
        }
        this.equipment = equipment;
    }

    /**
     *
     * @param e - equipment that we want to add to home
     */
    public void add(Equipment e) {
        if (e == null){
            return;
        }

        Equipment[] newEquipment = new Equipment[equipment.length + 1];

        for (int i = 0; i < equipment.length; i++) {
            newEquipment[i] = equipment[i];
        }
        newEquipment[equipment.length] = e;

        equipment = newEquipment;
    }

    /**
     *
     * @param e - equipment that we want to remove from home
     */
    public void remove(Equipment e) {
        if (e == null){
            return;
        }

        if (atHome(e)) {
            Equipment[] newEquipment = new Equipment[equipment.length - 1];

            for (int i = 0, j = 0; i < equipment.length; i++, j++) {
                if (!(e.equals(equipment[i]))) {
                    newEquipment[j] = equipment[i];
                } else {
                    j--;
                }
            }
            equipment = newEquipment;
        }
    }

    /**
     *
     * @param e - is equipment at home
     * @return true if equipment is at home
     */
    public boolean atHome(Equipment e) {
        if (e == null) {
            return false;
        }

        for (Equipment device : equipment) {
            if (e.equals(device)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Home home = (Home) o;
        return Arrays.equals(equipment, home.equipment);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(equipment);
    }

    @Override
    public String toString() {
        return "Home{" +
                "equipment=" + Arrays.toString(equipment) +
                '}';
    }
}
