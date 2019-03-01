package by.epam.javatraning.aksenov.task1.model.entity;

import by.epam.javatraning.aksenov.task1.model.exception.NegativeArgumentException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MicrowaveTest {
    private Microwave microwave;

    @BeforeTest
    public void setLamp() {
        microwave = new Microwave(120.5, 60, true, 10);
    }

    @Test
    public void testConstructorMicrowave() {
        Microwave microwave = new Microwave(120, 60, true, 10);

        double expected = 10;
        double actual = microwave.getVolume();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testConstructorMicrowaveNegativeArg() {
        Microwave microwave = new Microwave(120, 60, true, -10);

        double expected = 0;
        double actual = microwave.getVolume();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testConstructorMicrowaveCopier() {
        Microwave microwaveCopy = new Microwave(microwave, 14);

        double expected = 14;
        double actual = microwaveCopy.getVolume();

        Assert.assertEquals(expected, actual);
    }

    @Test(expectedExceptions = NegativeArgumentException.class)
    public void setVolume() {
        double expected = 12;

        microwave.setVolume(12);

        double actual = microwave.getVolume();

        Assert.assertEquals(expected, actual);

        microwave.setVolume(-10);
    }
}
