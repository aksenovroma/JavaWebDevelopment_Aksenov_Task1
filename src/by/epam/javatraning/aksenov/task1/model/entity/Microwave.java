package by.epam.javatraning.aksenov.task1.model.entity;

import by.epam.javatraning.aksenov.task1.model.exception.logic.MicrowaveVolumeWrongException;

/**
 * @author aksenov
 * @version 1.0
 *
 * Entity class for storing information about microwave
 * Class Microwave extends Equipment and realises new field - volume
 */

public class Microwave extends Equipment {
    private static final String ILLEGAL_ARGUMENT_EXC = "argument can't be negative or null";

    private double volume;

    public Microwave() {
    }

    public Microwave(double price, double power, boolean selector) {
        super(price, power, selector);
    }

    public Microwave(double price, double power, boolean selector, double volume) {
        super(price, power, selector);
        if (volume > 0) {
            this.volume = volume;
        }
    }

    public Microwave(Equipment equipment, double volume) {
        super(equipment);
        if (volume > 0) {
            this.volume = volume;
        }
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) throws MicrowaveVolumeWrongException{
        if (volume <= 0) {
            throw new MicrowaveVolumeWrongException(ILLEGAL_ARGUMENT_EXC);
        }
        this.volume = volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Microwave microwave = (Microwave) o;
        return Double.compare(microwave.volume, volume) == 0;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = PRIME * result + new Double(volume).hashCode();

        return result;
    }

    @Override
    public String toString() {
        return "Microwave{" + super.toString() +
                ", volume=" + volume +
                '}';
    }
}
