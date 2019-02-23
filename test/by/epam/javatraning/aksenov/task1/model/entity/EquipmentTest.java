package by.epam.javatraning.aksenov.task1.model.entity;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EquipmentTest {
    private Equipment equipment;

    @BeforeTest
    public void setEquipment() {
        equipment = new Equipment(200.5, 650.9, false);
    }

    @Test
    public void constructorEquipmentTest() {
        Equipment equipment1 = new Equipment(120, 50, true);
        Equipment equipment2 = new Equipment(-120, -50, true);
        Equipment equipment3 = new Equipment(equipment1);
        Equipment equipment4 = new Equipment(null);

        double expected1 = 120;
        double actual1 = equipment1.getPrice();

        double expected2 = 50;
        double actual2 = equipment1.getPower();

        double expected3 = 0;
        double actual3 = equipment2.getPrice();

        double expected4 = 0;
        double actual4 = equipment2.getPower();

        double expected5 = 120;
        double actual5 = equipment3.getPrice();

        double expected6 = 50;
        double actual6 = equipment3.getPower();

        double expected7 = 0;
        double actual7 = equipment4.getPrice();

        double expected8 = 0;
        double actual8 = equipment4.getPower();

        boolean actual9 = equipment4.isSelector();

        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
        Assert.assertEquals(expected3, actual3);
        Assert.assertEquals(expected4, actual4);
        Assert.assertEquals(expected5, actual5);
        Assert.assertEquals(expected6, actual6);
        Assert.assertEquals(expected7, actual7);
        Assert.assertEquals(expected8, actual8);
        Assert.assertFalse(actual9);

    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void setPrice() {
        double expected = 100;

        equipment.setPrice(100);

        double actual = equipment.getPrice();

        Assert.assertEquals(expected, actual);

        equipment.setPrice(-20);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void setPower() {
        double expected = 100;

        equipment.setPower(100);

        double actual = equipment.getPower();

        Assert.assertEquals(expected, actual);

        equipment.setPower(-100);
    }

}
