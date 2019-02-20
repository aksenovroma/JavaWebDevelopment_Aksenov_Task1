package by.epam.javatraning.aksenov.task1.model.entity;

import java.util.Objects;

public class Television extends Equipment {
    private static final String ILLEGAL_ARGUMENT_EXC = "argument can't be negative or null";

    private double diagonal;

    public Television() {
    }

    public Television(double price, double power, boolean selector) {
        super(price, power, selector);
    }

    public Television(double price, double power, boolean selector, double diagonal) {
        super(price, power, selector);
        if (diagonal > 0) {
            this.diagonal = diagonal;
        }
    }

    public Television(Equipment equipment, double diagonal) {
        super(equipment);
        if (diagonal > 0) {
            this.diagonal = diagonal;
        }
    }

    public double getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(double diagonal) {
        if (diagonal <= 0) {
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT_EXC);
        }
        this.diagonal = diagonal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Television that = (Television) o;
        return Double.compare(that.diagonal, diagonal) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), diagonal);
    }

    @Override
    public String toString() {
        return "Television{" + super.toString() +
                ", diagonal=" + diagonal +
                '}';
    }
}
