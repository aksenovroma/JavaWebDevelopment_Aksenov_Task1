package by.epam.javatraning.aksenov.task1.model.entity;

import by.epam.javatraning.aksenov.task1.model.exception.NegativeArgumentException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LampTest {
    private Lamp lamp;

    @BeforeTest
    public void setLamp() {
        lamp = new Lamp(120.5, 60, true, 2);
    }

    @Test
    public void constructorLampTest() {
        Lamp lamp1 = new Lamp(120, 60, true, 1);
        Lamp lamp2 = new Lamp(120, 60, true, -1);
        Lamp lamp3 = new Lamp(lamp1, 4);

        int expected1 = 1;
        int actual1 = lamp1.getLightbulb();

        int expected2 = 0;
        int actual2 = lamp2.getLightbulb();

        int expected3 = 4;
        int actual3 = lamp3.getLightbulb();

        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
        Assert.assertEquals(expected3, actual3);
    }

    @Test(expectedExceptions = NegativeArgumentException.class)
    public void setLightbulb() {
        double expected = 2;

        lamp.setLightbulb(2);

        double actual = lamp.getLightbulb();

        Assert.assertEquals(expected, actual);

        lamp.setLightbulb(-1);
    }
}
