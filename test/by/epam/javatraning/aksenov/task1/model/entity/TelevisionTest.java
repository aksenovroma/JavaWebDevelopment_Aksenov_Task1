package by.epam.javatraning.aksenov.task1.model.entity;

import by.epam.javatraning.aksenov.task1.model.exception.TelevisionDiagonalWrongException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TelevisionTest {
    private Television television;

    @BeforeTest
    public void setLamp() {
        television = new Television(120.5, 60, true, 20);
    }

    @Test
    public void testConstructorTelevision() {
        Television television = new Television(120, 60, true, 19);

        double expected = 19;
        double actual = television.getDiagonal();

        assertEquals(expected, actual);
    }

    @Test
    public void testConstructorTelevisionNegativeArg() {
        Television television = new Television(120, 60, true, -19);

        double expected = 0;
        double actual = television.getDiagonal();

        assertEquals(expected, actual);
    }

    @Test
    public void testConstructorTelevisionCopier() {
        Television televisionCopy = new Television(television, 22);

        double expected = 22;
        double actual = televisionCopy.getDiagonal();

        assertEquals(expected, actual);
    }

    @Test
    public void testSetDiagonal() throws TelevisionDiagonalWrongException {
        double expected = 21;

        television.setDiagonal(21);

        double actual = television.getDiagonal();

        assertEquals(expected, actual);
    }

    @Test(expectedExceptions = TelevisionDiagonalWrongException.class)
    public void testSetDiagonalWrong() throws TelevisionDiagonalWrongException {
        television.setDiagonal(-1);
    }
}
