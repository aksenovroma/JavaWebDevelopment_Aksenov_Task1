package by.epam.javatraning.aksenov.task1.model.entity;

import by.epam.javatraning.aksenov.task1.model.exception.logic.EquipmentPowerWrongException;
import by.epam.javatraning.aksenov.task1.model.exception.logic.EquipmentPriceWrongException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class EquipmentTest {
    private Equipment equipment;

    @BeforeMethod
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

        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
    }

    @Test
    public void testConstructorEquipmentNegativeArgs() {
        Equipment equipment = new Equipment(-120, -50, true);

        double expected1 = 0;
        double actual1 = equipment.getPrice();

        double expected2 = 0;
        double actual2 = equipment.getPower();

        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);

    }

    @Test
    public void testConstructorEquipmentCopier() {
        Equipment equipment = new Equipment(200.5, 650.9, false);
        Equipment equipmentCopy = new Equipment(equipment);

        double expected1 = 200.5;
        double actual1 = equipmentCopy.getPrice();

        double expected2 = 650.9;
        double actual2 = equipmentCopy.getPower();

        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
    }

    @Test
    public void testConstructorNullArr() {
        Equipment equipment = new Equipment(null);

        double expected1 = 0;
        double actual1 = equipment.getPrice();

        double expected2 = 0;
        double actual2 = equipment.getPower();

        boolean actual3 = equipment.isSelector();

        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertFalse(actual3);
    }

    @Test
    public void testSetPrice() throws EquipmentPriceWrongException {
        double expected = 100;

        equipment.setPrice(100);

        double actual = equipment.getPrice();

        assertEquals(expected, actual);
    }

    @Test(expectedExceptions = EquipmentPriceWrongException.class)
    public void testSetPriceWrong() throws EquipmentPriceWrongException {
        equipment.setPrice(-20);
    }

    @Test
    public void setPower() throws EquipmentPowerWrongException {
        double expected = 100;

        equipment.setPower(100);

        double actual = equipment.getPower();

        assertEquals(expected, actual);
    }

    @Test(expectedExceptions = EquipmentPowerWrongException.class)
    public void testSetPowerWrong() throws EquipmentPowerWrongException {
        equipment.setPower(-100);
    }

    @Test
    public void testEquals() {
        Equipment equipment1 = equipment;
        Equipment equipment2 = equipment;

        boolean actual = equipment1.equals(equipment2);

        assertTrue(actual);
    }

    @Test
    public void testEqualsDifferentPrice() {
        Equipment equipment1 = new Equipment(100, 230, true);

        boolean actual = equipment.equals(equipment1);

        assertFalse(actual);
    }

    @Test
    public void testEqualsDifferentPower() {
        Equipment equipment1 = new Equipment(120, 200, true);

        boolean actual = equipment.equals(equipment1);

        assertFalse(actual);
    }

    @Test
    public void testEqualsDifferentSelector() {
        Equipment equipment1 = new Equipment(120, 230, false);

        boolean actual = equipment.equals(equipment1);

        assertFalse(actual);
    }

    @Test
    public void testEqualsSameObject() {
        boolean actual = equipment.equals(equipment);

        assertTrue(actual);
    }

    @Test
    public void testEqualsNullPtr() {
        Equipment equipment1 = null;

        boolean actual = equipment.equals(equipment1);

        assertFalse(actual);
    }

    @Test
    public void testEqualsOtherClass() {
        Object o = new Object();

        boolean actual = equipment.equals(o);

        assertFalse(actual);
    }

    @Test
    public void testHashCode() {
        Equipment equipment1 = new Equipment(200.5, 650.9, false);

        boolean actual = (equipment.hashCode() == equipment1.hashCode());

        assertTrue(actual);
    }

    @Test
    public void testHashCodeDifferentPrice() {
        Equipment equipment1 = new Equipment(200.4, 650.9, false);

        boolean actual = (equipment.hashCode() == equipment1.hashCode());

        assertFalse(actual);
    }

    @Test
    public void testHashCodeDifferentPower() {
        Equipment equipment1 = new Equipment(200.5, 650.0, false);

        boolean actual = (equipment.hashCode() == equipment1.hashCode());

        assertFalse(actual);
    }

    @Test
    public void testHashCodeDifferentSelector() {
        Equipment equipment1 = new Equipment(200.5, 650.9, true);

        boolean actual = (equipment.hashCode() == equipment1.hashCode());

        assertFalse(actual);
    }

    @Test
    public void testHashCodeSameObject() {
        Equipment equipment1 = equipment;

        boolean actual = (equipment.hashCode() == equipment1.hashCode());

        assertTrue(actual);
    }

    @Test
    public void testToString() {
        String expected = "price=200.5, power=650.9, selector=false";
        String actual = equipment.toString();

        assertEquals(expected, actual);
    }


}
