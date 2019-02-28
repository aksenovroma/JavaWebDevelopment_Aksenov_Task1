package by.epam.javatraning.aksenov.task1.model.entity;

import by.epam.javatraning.aksenov.task1.model.exception.NegativeArgumentException;
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
    public void testConstructorEquipment() {
        Equipment equipment = new Equipment(120, 50, true);

        double expected1 = 120;
        double actual1 = equipment.getPrice();

        double expected2 = 50;
        double actual2 = equipment.getPower();

        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
    }

    @Test
    public void testConstructorEquipmentNegativeArgs() {
        Equipment equipment = new Equipment(-120, -50, true);

        double expected1 = 0;
        double actual1 = equipment.getPrice();

        double expected2 = 0;
        double actual2 = equipment.getPower();

        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);

    }

    @Test
    public void testConstructorEquipmentCopier() {
        Equipment equipment = new Equipment(200.5, 650.9, false);
        Equipment equipmentCopy = new Equipment(equipment);

        double expected1 = 200.5;
        double actual1 = equipmentCopy.getPrice();

        double expected2 = 650.9;
        double actual2 = equipmentCopy.getPower();

        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
    }

    @Test
    public void testConstructorNullArr() {
        Equipment equipment4 = new Equipment(null);

        double expected1 = 0;
        double actual1 = equipment4.getPrice();

        double expected2 = 0;
        double actual2 = equipment4.getPower();

        boolean actual3 = equipment4.isSelector();

        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
        Assert.assertFalse(actual3);
    }

    @Test(expectedExceptions = NegativeArgumentException.class)
    public void setPrice() {
        double expected = 100;

        equipment.setPrice(100);

        double actual = equipment.getPrice();

        Assert.assertEquals(expected, actual);

        equipment.setPrice(-20);
    }

    @Test(expectedExceptions = NegativeArgumentException.class)
    public void setPower() {
        double expected = 100;

        equipment.setPower(100);

        double actual = equipment.getPower();

        Assert.assertEquals(expected, actual);

        equipment.setPower(-100);
    }

}
