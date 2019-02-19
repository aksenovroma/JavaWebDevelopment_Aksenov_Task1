package by.epam.javatraning.aksenov.task1.model.entity;

import java.util.Arrays;

public class Home {
    private static final String NULL_POINTER_EXC = "argument can't be null";
    private Equipment[] equipment;

    public Home(Equipment... equipment) {
        if (equipment != null){
            this.equipment = equipment;
        }
    }

    public Equipment[] getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment[] equipment) {
        if (equipment == null){
            throw new NullPointerException(NULL_POINTER_EXC);
        }
        this.equipment = equipment;
    }

    public void add(Equipment e){
        Equipment[] newEquipment = new Equipment[equipment.length + 1];

        for (int i = 0; i < equipment.length; i++){
            newEquipment[i] = equipment[i];
        }
        newEquipment[equipment.length] = e;

        equipment = newEquipment;
    }

    public void remove(Equipment e){
        if (atHome(e)){
            Equipment[] newEquipment = new Equipment[equipment.length - 1];

            for (int i = 0, j = 0; i < equipment.length; i++, j++){
                if (!(e.equals(equipment[i]))){
                    newEquipment[j] = equipment[i];
                } else {
                    j--;
                }
            }
            equipment = newEquipment;
        }
    }

    public boolean atHome(Equipment e){
        if (e == null){
            return false;
        }

        for (Equipment device : equipment){
            if (e.equals(device)){
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
