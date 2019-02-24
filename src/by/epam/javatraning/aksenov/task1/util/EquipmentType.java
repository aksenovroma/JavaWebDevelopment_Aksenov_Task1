package by.epam.javatraning.aksenov.task1.util;

import java.util.Objects;

/**
 * @author aksenov
 * @version 1.0
 *
 * EquipmentType is special entity-class that storing information about equipments
 */

public class EquipmentType {
    private static final String NULL_POINTER_EXC = "argument can't be null";
    private static final String ILLEGAL_ARGUMENT_EXC = "argument can't be negative or null";

    private String name;
    private double price;
    private double power;
    private boolean selector;
    private String someField;

    public EquipmentType(String name, double price, double power, boolean selector, String someField) {
        if (name != null) {
            this.name = name;
        }
        if (price > 0) {
            this.price = price;
        }
        if (power > 0) {
            this.power = power;
        }
        if (someField != null) {
            this.someField = someField;
        }
        this.selector = selector;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) {
            throw new NullPointerException(NULL_POINTER_EXC);
        }
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT_EXC);
        }
        this.price = price;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        if (power <= 0) {
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT_EXC);
        }
        this.power = power;
    }

    public boolean isSelector() {
        return selector;
    }

    public void setSelector(boolean selector) {
        this.selector = selector;
    }

    public String getSomeField() {
        return someField;
    }

    public void setSomeField(String someField) {
        if (someField != null) {
            throw new NullPointerException(NULL_POINTER_EXC);
        }
        this.someField = someField;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EquipmentType that = (EquipmentType) o;
        return Double.compare(that.price, price) == 0 &&
                Double.compare(that.power, power) == 0 &&
                selector == that.selector &&
                Objects.equals(name, that.name) &&
                Objects.equals(someField, that.someField);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, power, selector, someField);
    }

    @Override
    public String toString() {
        return "EquipmentType{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", power=" + power +
                ", selector=" + selector +
                ", someField='" + someField + '\'' +
                '}';
    }
}
