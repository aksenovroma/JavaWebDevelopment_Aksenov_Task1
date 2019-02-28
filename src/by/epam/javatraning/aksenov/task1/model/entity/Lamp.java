package by.epam.javatraning.aksenov.task1.model.entity;

import by.epam.javatraning.aksenov.task1.model.exception.NegativeArgumentException;
import by.epam.javatraning.aksenov.task1.model.exception.NullArgumentException;

import java.util.Objects;

/**
 * @author aksenov
 * @version 1.0
 *
 * Entity class for storing information about lamp
 * Class Lamp extends Equipment and realises new field - lightbulb
 */

public class Lamp extends Equipment {
    private static final String ILLEGAL_ARGUMENT_EXC = "argument can't be negative or null";

    private int lightbulb;

    public Lamp() {
    }

    public Lamp(double price, double power, boolean selector) {
        super(price, power, selector);
    }

    public Lamp(double price, double power, boolean selector, int lightbulb) {
        super(price, power, selector);
        if (lightbulb >= 0) {
            this.lightbulb = lightbulb;
        }
    }

    public Lamp(Equipment equipment, int lightbulb) {
        super(equipment);
        if (lightbulb >= 0) {
            this.lightbulb = lightbulb;
        }
    }

    public int getLightbulb() {
        return lightbulb;
    }

    public void setLightbulb(int lightbulb) {
        if (lightbulb < 0) {
            throw new NegativeArgumentException(ILLEGAL_ARGUMENT_EXC);
        }
        this.lightbulb = lightbulb;
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
