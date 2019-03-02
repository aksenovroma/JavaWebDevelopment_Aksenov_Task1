package by.epam.javatraning.aksenov.task1.model.entity;

import by.epam.javatraning.aksenov.task1.model.exception.EquipmentPowerWrongException;
import by.epam.javatraning.aksenov.task1.model.exception.EquipmentPriceWrongException;
import by.epam.javatraning.aksenov.task1.model.exception.WrongArgumentException;

import java.util.Objects;

/**
 * @author aksenov
 * @version 1.0
 *
 * Entity class for storing electrical information
 */

public class Equipment {
    private static final String ILLEGAL_ARGUMENT_EXC = "argument can't be negative or null";

    private double price;
    private double power;
    private boolean selector;

    public Equipment() {
    }

    public Equipment(double price, double power, boolean selector) {
        if (price > 0) {
            this.price = price;
        }
        if (power > 0) {
            this.power = power;
        }
        this.selector = selector;
    }

    public Equipment(Equipment equipment) {
        if (equipment != null) {
            price = equipment.price;
            power = equipment.power;
            selector = equipment.selector;
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) throws EquipmentPriceWrongException{
        if (price <= 0) {
            throw new EquipmentPriceWrongException(ILLEGAL_ARGUMENT_EXC);
        }
        this.price = price;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) throws EquipmentPowerWrongException{
        if (power <= 0) {
            throw new EquipmentPowerWrongException();
        }
        this.power = power;
    }

    public boolean isSelector() {
        return selector;
    }

    public void setSelector(boolean selector) {
        this.selector = selector;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Equipment equipment = (Equipment) o;

        return Double.compare(equipment.price, price) == 0 &&
                Double.compare(equipment.power, power) == 0 &&
                selector == equipment.selector;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + new Double(price).hashCode();
        result = PRIME * result + new Double(power).hashCode();
        result = PRIME * result + (selector ? PRIME : 7);
        return result;
    }

    @Override
    public String toString() {
        return "price=" + price +
                ", power=" + power +
                ", selector=" + selector;
    }

}
