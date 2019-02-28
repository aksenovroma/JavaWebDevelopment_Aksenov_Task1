package by.epam.javatraning.aksenov.task1.model.entity;

import by.epam.javatraning.aksenov.task1.model.exception.NegativeArgumentException;
import by.epam.javatraning.aksenov.task1.model.exception.NullArgumentException;

import java.util.Objects;

/**
 * @author aksenov
 * @version 1.0
 *
 * Entity class for storing information about television
 * Class Television extends Equipment and realises new field - diagonal
 */

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
        if (diagonal >= 0) {
            this.diagonal = diagonal;
        }
    }

    public Television(Equipment equipment, double diagonal) {
        super(equipment);
        if (diagonal >= 0) {
            this.diagonal = diagonal;
        }
    }

    public double getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(double diagonal) {
        if (diagonal < 0) {
            throw new NegativeArgumentException(ILLEGAL_ARGUMENT_EXC);
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
