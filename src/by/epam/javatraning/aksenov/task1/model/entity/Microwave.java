package by.epam.javatraning.aksenov.task1.model.entity;

import java.util.Objects;

public class Microwave extends Equipment{
    private double volume;

    public Microwave() {}

    public Microwave(double price, double power, boolean selector, double volume) {
        super(price, power, selector);
        this.volume = volume;
    }

    public Microwave(Equipment equipment, double volume) {
        super(equipment);
        this.volume = volume;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
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
        return Objects.hash(super.hashCode(), volume);
    }

    @Override
    public String toString() {
        return "Microwave{" + super.toString() +
                "volume=" + volume +
                '}';
    }
}
