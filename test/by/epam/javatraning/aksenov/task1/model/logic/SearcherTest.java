package by.epam.javatraning.aksenov.task1.model.logic;

import by.epam.javatraning.aksenov.task1.model.entity.*;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SearcherTest {
    private Home home1;
    private Home home2;
    private Home home3;
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

        home1 = new Home(equipment1);
        home2 = new Home(equipment2);
        home3 = null;
    }

    @Test
    public void findIndexOfEquipmentByPowerTest() {
        int expected1 = 2;
        int actual1 = Searcher.findIndexOfEquipmentByPower(home1, 120);

        int expected2 = -1;
        int actual2 = Searcher.findIndexOfEquipmentByPower(home2, 120);

        int expected3 = -1;
        int actual3 = Searcher.findIndexOfEquipmentByPower(home3, 120);

        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
        Assert.assertEquals(expected3, actual3);
    }

    @Test
    public void findIndexOfEquipmentByPriceTest() {
        int expected1 = 1;
        int actual1 = Searcher.findIndexOfEquipmentByPrice(home1, 560);

        int expected2 = -1;
        int actual2 = Searcher.findIndexOfEquipmentByPower(home2, 560);

        int expected3 = -1;
        int actual3 = Searcher.findIndexOfEquipmentByPower(home3, 560);

        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
        Assert.assertEquals(expected3, actual3);
    }

    @Test
    public void findMaxPriceEquipmentTest() {
        Equipment expected1 = television;
        Equipment actual1 = Searcher.findMaxPriceEquipment(home1);

        Equipment expected2 = null;
        Equipment actual2 = Searcher.findMaxPriceEquipment(home2);

        Equipment expected3 = null;
        Equipment actual3 = Searcher.findMaxPriceEquipment(home3);

        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
        Assert.assertEquals(expected3, actual3);
    }

    @Test
    public void findMinPriceEquipmentTest() {
        Equipment expected1 = lamp2;
        Equipment actual1 = Searcher.findMinPriceEquipment(home1);

        Equipment expected2 = null;
        Equipment actual2 = Searcher.findMinPriceEquipment(home2);

        Equipment expected3 = null;
        Equipment actual3 = Searcher.findMinPriceEquipment(home3);

        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
        Assert.assertEquals(expected3, actual3);
    }

    @Test
    public void findMaxPowerEquipmentTest() {
        Equipment expected1 = microwave;
        Equipment actual1 = Searcher.findMaxPowerEquipment(home1);

        Equipment expected2 = null;
        Equipment actual2 = Searcher.findMaxPowerEquipment(home2);

        Equipment expected3 = null;
        Equipment actual3 = Searcher.findMaxPowerEquipment(home3);

        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
        Assert.assertEquals(expected3, actual3);
    }

    @Test
    public void findMinPowerEquipmentTest() {
        Equipment expected1 = lamp1;
        Equipment actual1 = Searcher.findMinPowerEquipment(home1);

        Equipment expected2 = null;
        Equipment actual2 = Searcher.findMinPowerEquipment(home2);

        Equipment expected3 = null;
        Equipment actual3 = Searcher.findMinPowerEquipment(home3);

        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
        Assert.assertEquals(expected3, actual3);
    }
}
