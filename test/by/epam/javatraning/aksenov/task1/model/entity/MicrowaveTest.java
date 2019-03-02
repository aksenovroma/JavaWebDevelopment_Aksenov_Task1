package by.epam.javatraning.aksenov.task1.model.entity;

import by.epam.javatraning.aksenov.task1.model.exception.MicrowaveVolumeWrongException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MicrowaveTest {
    private Microwave microwave;

    @BeforeMethod
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

    @Test
    public void testSetVolume() throws MicrowaveVolumeWrongException {
        double expected = 12;

        microwave.setVolume(12);

        double actual = microwave.getVolume();

        assertEquals(expected, actual);
    }

    @Test(expectedExceptions = MicrowaveVolumeWrongException.class)
    public void testSetVolumeWrong() throws MicrowaveVolumeWrongException {
        microwave.setVolume(-10);
    }

    @Test
    public void testEquals() {
        Microwave microwave1 = microwave;
        Microwave microwave2 = microwave;

        boolean actual = microwave1.equals(microwave2);

        assertTrue(actual);
    }

    @Test
    public void testEqualsDifferentPrice() {
        Microwave microwave1 = new Microwave(100.5, 60, true, 10);

        boolean actual = microwave.equals(microwave1);

        assertFalse(actual);
    }

    @Test
    public void testEqualsDifferentPower() {
        Microwave microwave1 = new Microwave(120.5, 70, true, 10);

        boolean actual = microwave.equals(microwave1);

        assertFalse(actual);
    }

    @Test
    public void testEqualsDifferentSelector() {
        Microwave microwave1 = new Microwave(120.5, 60, false, 10);

        boolean actual = microwave.equals(microwave1);

        assertFalse(actual);
    }

    @Test
    public void testEqualsDifferentVolume() {
        Microwave microwave1 = new Microwave(120.5, 60, true, 12);

        boolean actual = microwave.equals(microwave1);

        assertFalse(actual);
    }

    @Test
    public void testEqualsSameObject() {
        boolean actual = microwave.equals(microwave);

        assertTrue(actual);
    }

    @Test
    public void testEqualsNullPtr() {
        Microwave microwave1 = null;

        boolean actual = microwave.equals(microwave1);

        assertFalse(actual);
    }

    @Test
    public void testEqualsOtherClass() {
        Object o = new Object();

        boolean actual = microwave.equals(o);

        assertFalse(actual);
    }

    @Test
    public void testHashCode() {
        Microwave microwave1 = new Microwave(120.5, 60, true, 10);

        boolean actual = (microwave.hashCode() == microwave1.hashCode());

        assertTrue(actual);
    }

    @Test
    public void testHashCodeDifferentVolume() {
        Microwave microwave1 = new Microwave(120.5, 60, true, 13);

        boolean actual = (microwave.hashCode() == microwave1.hashCode());

        assertFalse(actual);
    }

    @Test
    public void testHashCodeSameObject() {
        Microwave microwave1 = microwave;

        boolean actual = (microwave.hashCode() == microwave1.hashCode());

        assertTrue(actual);
    }

    @Test
    public void testToString() {
        String expected = "Microwave{price=120.5, power=60.0, selector=true, volume=10.0}";
        String actual = microwave.toString();

        assertEquals(expected, actual);
    }
}
