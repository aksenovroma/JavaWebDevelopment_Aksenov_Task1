package by.epam.javatraning.aksenov.task1.model.entity;

import java.util.Objects;

public class Lamp extends Equipment{
    private int lightbulb;

    public Lamp() {}

    public Lamp(double price, double power, boolean selector) {
        super(price, power, selector);
    }

    public Lamp(double price, double power, boolean selector, int lightbulb) {
        super(price, power, selector);
        this.lightbulb = lightbulb;
    }

    public Lamp(Equipment equipment, int lightbulb) {
        super(equipment);
        this.lightbulb = lightbulb;
    }

    public int getLightbulb() {
        return lightbulb;
    }

    public void setLightbulb(int lightbulb) {
        if (lightbulb > 0){
            this.lightbulb = lightbulb;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Lamp lamp = (Lamp) o;
        return lightbulb == lamp.lightbulb;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), lightbulb);
    }

    @Override
    public String toString() {
        return "Lamp{" + super.toString() +
                ", lightbulb=" + lightbulb +
                '}';
    }
}
