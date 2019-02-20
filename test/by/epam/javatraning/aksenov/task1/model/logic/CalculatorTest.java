package by.epam.javatraning.aksenov.task1.model.logic;

import by.epam.javatraning.aksenov.task1.model.entity.*;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CalculatorTest {
    private Home home1;
    private Home home2;
    private Home home3;

    @BeforeTest
    public void setHome() {
        Lamp lamp1 = new Lamp(120.5, 60, true, 2);
        Microwave microwave = new Microwave(560, 650, false, 15);
        Television television = new Television(890.5, 120, true, 21);
        Lamp lamp2 = new Lamp(110, 80, false, 3);

        Equipment[] equipment1 = {lamp1, microwave, television, lamp2};
        Equipment[] equipment2 = {};

        home1 = new Home(equipment1);
        home2 = new Home(equipment2);
        home3 = null;
    }

    @Test
    public void sumPowerOfDevicesTest() {
        double expected1 = 910;
        double actual1 = Calculator.sumPowerOfDevices(home1);

        double expected2 = 0;
        double actual2 = Calculator.sumPowerOfDevices(home2);

        double expected3 = 0;
        double actual3 = Calculator.sumPowerOfDevices(home3);

        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
        Assert.assertEquals(expected3, actual3);
    }

    @Test
    public void sumPowerOfOnDevicesTest() {
        double expected1 = 180;
        double actual1 = Calculator.sumPowerOfOnDevices(home1);

        double expected2 = 0;
        double actual2 = Calculator.sumPowerOfOnDevices(home2);

        double expected3 = 0;
        double actual3 = Calculator.sumPowerOfOnDevices(home3);

        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
        Assert.assertEquals(expected3, actual3);
    }
}
