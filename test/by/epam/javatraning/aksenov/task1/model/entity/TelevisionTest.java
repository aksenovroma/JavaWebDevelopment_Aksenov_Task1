package by.epam.javatraning.aksenov.task1.model.entity;

import by.epam.javatraning.aksenov.task1.model.exception.TelevisionDiagonalWrongException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TelevisionTest {
    private Television television;

    @BeforeMethod
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

    @Test
    public void testEquals() {
        Television television1 = television;
        Television television2 = television;

        boolean actual = television1.equals(television2);

        assertTrue(actual);
    }

    @Test
    public void testEqualsDifferentPrice() {
        Television television1 = new Television(100.5, 60, true, 20);

        boolean actual = television.equals(television1);

        assertFalse(actual);
    }

    @Test
    public void testEqualsDifferentPower() {
        Television television1 = new Television(120.5, 70, true, 20);

        boolean actual = television.equals(television1);

        assertFalse(actual);
    }

    @Test
    public void testEqualsDifferentSelector() {
        Television television1 = new Television(120.5, 60, false, 20);

        boolean actual = television.equals(television1);

        assertFalse(actual);
    }

    @Test
    public void testEqualsDifferentDiagonal() {
        Television television1 = new Television(120.5, 60, true, 22);

        boolean actual = television.equals(television1);

        assertFalse(actual);
    }

    @Test
    public void testEqualsSameObject() {
        boolean actual = television.equals(television);

        assertTrue(actual);
    }

    @Test
    public void testEqualsNullPtr() {
        Television television1 = null;

        boolean actual = television.equals(television1);

        assertFalse(actual);
    }

    @Test
    public void testEqualsOtherClass() {
        Object o = new Object();

        boolean actual = television.equals(o);

        assertFalse(actual);
    }

    @Test
    public void testToString() {
        String expected = "Television{price=120.5, power=60.0, selector=true, diagonal=20.0}";
        String actual = television.toString();

        assertEquals(expected, actual);
    }
}
