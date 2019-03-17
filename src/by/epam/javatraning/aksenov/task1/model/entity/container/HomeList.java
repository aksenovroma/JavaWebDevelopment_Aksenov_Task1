package by.epam.javatraning.aksenov.task1.model.entity.container;

import by.epam.javatraning.aksenov.task1.model.entity.Equipment;
import by.epam.javatraning.aksenov.task1.model.exception.logic.HomeEquipmentWrongException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class HomeList implements Home {
    private List<Equipment> equipment = new ArrayList<>();

    public HomeList() {
    }

    public HomeList(List<Equipment> equipment) {
        if (equipment != null) {
            this.equipment = equipment;
        }
    }

    public HomeList(Equipment[] equipment) {
        if (equipment != null) {
            this.equipment = Arrays.asList(equipment);
        }
    }

    public HomeList(Home home) {
        if (home != null) {
            Equipment[] equipments = home.getEquipment().clone();
            this.equipment = new ArrayList<>(Arrays.asList(equipments));
        }
    }

    @Override
    public Equipment[] getEquipment() {
        Equipment[] equipments = new Equipment[equipment.size()];

        for (int i = 0; i < equipments.length; i++) {
            equipments[i] = equipment.get(i);
        }

        return equipments;
    }

    @Override
    public void set(Equipment e, int index) {
        if (e != null && (index >= 0 && index < equipment.size())) {
            equipment.set(index, e);
        }
    }

    @Override
    public void setEquipment(Equipment[] equipment) throws HomeEquipmentWrongException {
        if (equipment == null) {
            throw new HomeEquipmentWrongException();
        }
        this.equipment = Arrays.asList(equipment);
    }

    @Override
    public Equipment get(int index) {
        if (index >= 0 && index < equipment.size()){
            return equipment.get(index);
        }
        return null;
    }

    @Override
    public void add(Equipment e) {
        if (e != null) {
            equipment.add(e);
        }
    }

    @Override
    public void remove(Equipment e) {
        if (atHome(e)) {
            equipment.remove(e);
        }
    }

    @Override
    public boolean atHome(Equipment e) {
        if (e != null) {
            return equipment.contains(e);
        }
        return false;
    }

    @Override
    public int size() {
        return equipment.size();
    }

    @Override
    public boolean isEmpty() {
        return equipment.isEmpty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HomeList homeList = (HomeList) o;
        return Objects.equals(equipment, homeList.equipment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(equipment);
    }

    @Override
    public String toString() {
        return "HomeList{" +
                "equipment=" + equipment +
                '}';
    }
}
