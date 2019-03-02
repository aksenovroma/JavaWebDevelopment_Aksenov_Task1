package by.epam.javatraning.aksenov.task1.model.entity;

import by.epam.javatraning.aksenov.task1.model.exception.LampLightbulbWrongExceprion;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LampTest {
    private Lamp lamp;

    @BeforeTest
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
}
