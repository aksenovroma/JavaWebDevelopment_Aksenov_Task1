package by.epam.javatraning.aksenov.task1.model.entity;

import by.epam.javatraning.aksenov.task1.model.exception.LampLightbulbWrongExceprion;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LampTest {
    private Lamp lamp;

    @BeforeMethod
    public void setLamp() {
        lamp = new Lamp(120.5, 60, true, 2);
    }

    @Test
    public void testConstructorLamp() {
        Lamp lamp = new Lamp(120, 60, true, 1);

        int expected = 1;
        int actual = lamp.getLightbulb();

        assertEquals(expected, actual);
    }

    @Test
    public void testConstructorLampNegativeArg() {
        Lamp lamp = new Lamp(120, 60, true, -1);

        int expected = 0;
        int actual = lamp.getLightbulb();

        assertEquals(expected, actual);
    }

    @Test
    public void testConstructorLampCopier() {
        Lamp lampCopy = new Lamp(lamp, 4);

        int expected = 4;
        int actual = lampCopy.getLightbulb();

        assertEquals(expected, actual);
    }

    @Test
    public void testSetLightbulb() throws LampLightbulbWrongExceprion {
        double expected = 2;

        lamp.setLightbulb(2);

        double actual = lamp.getLightbulb();

        assertEquals(expected, actual);
    }

    @Test(expectedExceptions = LampLightbulbWrongExceprion.class)
    public void testSetLightbulbWrong() throws LampLightbulbWrongExceprion {
        lamp.setLightbulb(-1);
    }

    @Test
    public void testEquals() {
        Lamp lamp1 = lamp;
        Lamp lamp2 = lamp;

        boolean actual = lamp1.equals(lamp2);

        assertTrue(actual);
    }

    @Test
    public void testEqualsDifferentPrice() {
        Lamp lamp1 = new Lamp(100.5, 60, true, 2);

        boolean actual = lamp.equals(lamp1);

        assertFalse(actual);
    }

    @Test
    public void testEqualsDifferentPower() {
        Lamp lamp1 = new Lamp(120.5, 70, true, 2);

        boolean actual = lamp.equals(lamp1);

        assertFalse(actual);
    }

    @Test
    public void testEqualsDifferentSelector() {
        Lamp lamp1 = new Lamp(120.5, 60, false, 2);

        boolean actual = lamp.equals(lamp1);

        assertFalse(actual);
    }

    @Test
    public void testEqualsDifferentLightbulb() {
        Lamp lamp1 = new Lamp(120.5, 60, true, 3);

        boolean actual = lamp.equals(lamp1);

        assertFalse(actual);
    }

    @Test
    public void testEqualsSameObject() {
        boolean actual = lamp.equals(lamp);

        assertTrue(actual);
    }

    @Test
    public void testEqualsNullPtr() {
        Lamp lamp1 = null;

        boolean actual = lamp.equals(lamp1);

        assertFalse(actual);
    }

    @Test
    public void testEqualsOtherClass() {
        Object o = new Object();

        boolean actual = lamp.equals(o);

        assertFalse(actual);
    }

    @Test
    public void testToString() {
        String expected = "Lamp{price=120.5, power=60.0, selector=true, lightbulb=2}";
        String actual = lamp.toString();

        assertEquals(expected, actual);
    }
}
