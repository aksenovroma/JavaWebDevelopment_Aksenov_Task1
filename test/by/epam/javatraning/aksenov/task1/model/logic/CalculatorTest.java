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
    public void testSumPowerOfDevices(){
        double expected = 910;
        double actual = Calculator.sumPowerOfDevices(home1);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSumPowerOfDevicesEmptyArr(){
        double expected = 0;
        double actual = Calculator.sumPowerOfDevices(home2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSumPowerOfDevicesNullPtr(){
        double expected = 0;
        double actual = Calculator.sumPowerOfDevices(home3);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void sumPowerOfOnDevicesTest() {
        double expected = 180;
        double actual = Calculator.sumPowerOfOnDevices(home1);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSumPowerOfOnDevicesEmptyArr(){
        double expected = 0;
        double actual = Calculator.sumPowerOfOnDevices(home2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSumPowerOfOnDevicesNullPtr(){
        double expected = 0;
        double actual = Calculator.sumPowerOfOnDevices(home3);

        Assert.assertEquals(expected, actual);
    }
}
