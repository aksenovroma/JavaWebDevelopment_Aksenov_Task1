package by.epam.javatraning.aksenov.task1.model.entity.container;

import by.epam.javatraning.aksenov.task1.model.entity.Equipment;
import by.epam.javatraning.aksenov.task1.model.entity.Lamp;
import by.epam.javatraning.aksenov.task1.model.entity.Microwave;
import by.epam.javatraning.aksenov.task1.model.entity.Television;
import by.epam.javatraning.aksenov.task1.model.exception.logic.HomeEquipmentWrongException;
import by.epam.javatraning.aksenov.task1.model.exception.logic.WrongArgumentException;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.List;

/**
 * @author aksenov
 * @version 1.0
 *
 * Entity class for storing information about electrical equipment in the house
 * Class storing data in equipment array
 * Class Home has methods for adding and removing equipment from house
 */

public class HomeArray implements Home{
    private static final Logger log = Logger.getRootLogger();

    private static final String NULL_POINTER_EXC = "argument can't be null";

    private Equipment[] equipment = new Equipment[0];

    public HomeArray(Equipment... equipment) {
        if (equipment != null) {
            this.equipment = equipment;
        }
    }

    public HomeArray(List<Equipment> equipment) {
        if (equipment != null) {
            this.equipment = new Equipment[equipment.size()];

            for (int i = 0; i < size(); i++) {
                this.equipment[i] = equipment.get(i);
            }
        }
    }

    public HomeArray(Home home) {
        if (home != null) {
            Equipment[] equipmentArr = home.getEquipment();
            equipment = new Equipment[equipmentArr.length];

            for (int i = 0; i < equipmentArr.length; i++) {
                if (equipmentArr[i] != null) {
                    Equipment equip = new Equipment();

                    if (equipmentArr[i] instanceof Lamp) {
                        equip = new Lamp();
                        try {
                            equip.setPrice(equipmentArr[i].getPrice());
                            equip.setPower(equipmentArr[i].getPower());
                            ((Lamp) equip).setLightbulb(((Lamp) equipmentArr[i]).getLightbulb());
                        } catch (WrongArgumentException exc) {
                            log.error(exc);
                        }
                    } else if (equipmentArr[i] instanceof Television) {
                        equip = new Television();
                        try {
                            equip.setPrice(equipmentArr[i].getPrice());
                            equip.setPower(equipmentArr[i].getPower());
                            ((Television) equip).setDiagonal(((Television) equipmentArr[i]).getDiagonal());
                        } catch (WrongArgumentException exc) {
                            log.error(exc);
                        }
                    } else if (equipmentArr[i] instanceof Microwave) {
                        equip = new Microwave();
                        try {
                            equip.setPrice(equipmentArr[i].getPrice());
                            equip.setPower(equipmentArr[i].getPower());
                            ((Microwave) equip).setVolume(((Microwave) equipmentArr[i]).getVolume());
                        } catch (WrongArgumentException exc) {
                            log.error(exc);
                        }
                    }
                    equipment[i] = equip;
                }
            }
        }
    }

    @Override
    public Equipment[] getEquipment() {
        return equipment;
    }

    @Override
    public void setEquipment(Equipment[] equipment) throws HomeEquipmentWrongException{
        if (equipment == null) {
            throw new HomeEquipmentWrongException(NULL_POINTER_EXC);
        }
        this.equipment = equipment;
    }

    @Override
    public void set(Equipment e, int index) {
        if (e != null && (index >= 0 && index < equipment.length)) {
            equipment[index] = e;
        }
    }

    @Override
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

    @Override
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

    @Override
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
    public Equipment get(int index) {
        if (index >= 0 && index < equipment.length) {
            return equipment[index];
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return equipment.length == 0;
    }

    @Override
    public int size() {
        return equipment.length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HomeArray home = (HomeArray) o;
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
