package by.epam.javatraning.aksenov.task1.util;

import java.util.Objects;

public class EquipmentType {
    private String name;
    private double price;
    private double power;
    private boolean selector;
    private String someField;

    public EquipmentType(String name, double price, double power, boolean selector, String someField) {
        this.name = name;
        this.price = price;
        this.power = power;
        this.selector = selector;
        this.someField = someField;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
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
