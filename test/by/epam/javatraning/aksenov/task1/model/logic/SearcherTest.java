package by.epam.javatraning.aksenov.task1.model.logic;

import by.epam.javatraning.aksenov.task1.model.entity.*;
import by.epam.javatraning.aksenov.task1.model.entity.container.HomeArray;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SearcherTest {
    private HomeArray home1;
    private HomeArray home2;
    private HomeArray home3;
    private Lamp lamp1;
    private Lamp lamp2;
    private Microwave microwave;
    private Television television;

    @BeforeTest
    public void setHome() {
        lamp1 = new Lamp(120.5, 60, true, 2);
        microwave = new Microwave(560, 650, false, 15);
        television = new Television(890.5, 120, true, 21);
        lamp2 = new Lamp(110, 80, false, 3);

        Equipment[] equipment1 = {lamp1, microwave, television, lamp2};
        Equipment[] equipment2 = {};

        home1 = new HomeArray(equipment1);
        home2 = new HomeArray(equipment2);
        home3 = null;
    }

    @Test
    public void testFindIndexOfEquipmentByPower() {
        int expected = 2;
        int actual = Searcher.findIndexOfEquipmentByPower(home1, 120);

        assertEquals(expected, actual);
    }

    @Test
    public void testFindIndexOfEquipmentByPowerEmptyArr(){
        int expected = -1;
        int actual = Searcher.findIndexOfEquipmentByPower(home2, 120);

        assertEquals(expected, actual);
    }

    @Test
    public void testFindIndexOfEquipmentByPowerNullPtr(){
        int expected = -1;
        int actual = Searcher.findIndexOfEquipmentByPower(home3, 120);

        assertEquals(expected, actual);
    }



    @Test
    public void testFindIndexOfEquipmentByPrice() {
        int expected = 1;
        int actual = Searcher.findIndexOfEquipmentByPrice(home1, 560);

        assertEquals(expected, actual);
    }

    @Test
    public void testFindIndexOfEquipmentByPriceEmptyArr(){
        int expected = -1;
        int actual = Searcher.findIndexOfEquipmentByPrice(home2, 560);

        assertEquals(expected, actual);
    }

    @Test
    public void testFindIndexOfEquipmentByPriceNullPtr(){
        int expected = -1;
        int actual = Searcher.findIndexOfEquipmentByPrice(home3, 560);

        assertEquals(expected, actual);
    }



    @Test
    public void testFindMaxPriceEquipment() {
        Equipment expected = television;
        Equipment actual = Searcher.findMaxPriceEquipment(home1);

        assertEquals(expected, actual);
    }

    @Test
    public void testFindMaxPriceEquipmentEmptyArr(){
        Equipment expected = null;
        Equipment actual = Searcher.findMaxPriceEquipment(home2);

        assertEquals(expected, actual);
    }

    @Test
    public void testFindMaxPriceEquipmentNullPtr(){
        Equipment expected = null;
        Equipment actual = Searcher.findMaxPriceEquipment(home3);

        assertEquals(expected, actual);
    }



    @Test
    public void testFindMinPriceEquipment() {
        Equipment expected = lamp2;
        Equipment actual = Searcher.findMinPriceEquipment(home1);

        assertEquals(expected, actual);
    }

    @Test
    public void testFindMinPriceEquipmentEmptyArr(){
        Equipment expected = null;
        Equipment actual = Searcher.findMinPriceEquipment(home2);

        assertEquals(expected, actual);
    }

    @Test
    public void testFindMinPriceEquipmentNullPtr(){
        Equipment expected = null;
        Equipment actual = Searcher.findMinPriceEquipment(home3);

        assertEquals(expected, actual);
    }



    @Test
    public void testFindMaxPowerEquipment() {
        Equipment expected1 = microwave;
        Equipment actual1 = Searcher.findMaxPowerEquipment(home1);

        assertEquals(expected1, actual1);
    }

    @Test
    public void testFindMaxPowerEquipmentEmptyArr(){
        Equipment expected = null;
        Equipment actual = Searcher.findMaxPowerEquipment(home2);

        assertEquals(expected, actual);
    }

    @Test
    public void testFindMaxPowerEquipmentNullPtr(){
        Equipment expected = null;
        Equipment actual = Searcher.findMaxPowerEquipment(home3);

        assertEquals(expected, actual);
    }



    @Test
    public void testFindMinPowerEquipment() {
        Equipment expected = lamp1;
        Equipment actual = Searcher.findMinPowerEquipment(home1);

        assertEquals(expected, actual);
    }

    @Test
    public void testFindMinPowerEquipmentEmptyArr(){
        Equipment expected = null;
        Equipment actual = Searcher.findMinPowerEquipment(home2);

        assertEquals(expected, actual);
    }

    @Test
    public void testFindMinPowerEquipmentNullPtr(){
        Equipment expected = null;
        Equipment actual = Searcher.findMinPowerEquipment(home3);

        assertEquals(expected, actual);
    }
}
