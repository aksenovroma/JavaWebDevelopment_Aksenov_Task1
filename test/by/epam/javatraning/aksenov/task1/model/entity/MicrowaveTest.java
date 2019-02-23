package by.epam.javatraning.aksenov.task1.model.entity;

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
    public void constructorMicrowaveTest() {
        Microwave lamp1 = new Microwave(120, 60, true, 10);
        Microwave lamp2 = new Microwave(120, 60, true, -10);
        Microwave lamp3 = new Microwave(lamp1, 14);

        double expected1 = 10;
        double actual1 = lamp1.getVolume();

        double expected2 = 0;
        double actual2 = lamp2.getVolume();

        double expected3 = 14;
        double actual3 = lamp3.getVolume();

        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
        Assert.assertEquals(expected3, actual3);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void setVolume() {
        double expected = 12;

        microwave.setVolume(12);

        double actual = microwave.getVolume();

        Assert.assertEquals(expected, actual);

        microwave.setVolume(-10);
    }
}
