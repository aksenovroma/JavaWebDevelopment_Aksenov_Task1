package by.epam.javatraning.aksenov.task1.model.logic;

import by.epam.javatraning.aksenov.task1.model.entity.*;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SorterTest {
    private Home home1;
    private Home home2;
    private Home home3;
    private Home home4;
    private Lamp lamp1;
    private Lamp lamp2;
    private Television television;
    private Microwave microwave;

    @BeforeTest
    public void setHome() {
        lamp1 = new Lamp(120.5, 60, true, 2);
        microwave = new Microwave(560, 650, false, 15);
        television = new Television(890.5, 120, true, 21);
        lamp2 = new Lamp(110, 80, false, 3);

        Equipment[] equipment1 = new Equipment[]{lamp1, microwave, television, lamp2};
        Equipment[] equipment2 = new Equipment[]{microwave, television, lamp2, lamp1};
        Equipment[] equipment3 = new Equipment[]{};

        home1 = new Home(equipment1);
        home2 = new Home(equipment2);
        home3 = new Home(equipment3);
        home4 = null;
    }

    @Test
    public void testBubbleSortByPower() {
        Home expected = home2;
        Sorter.bubbleSortByPower(home1);
        Home actual = home1;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testBubbleSortByPowerNullPtr(){
        Home expected = home4;
        Sorter.bubbleSortByPower(home4);
        Home actual = home4;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testBubbleSortByPowerEmptyArr(){
        Home expected = home3;
        Sorter.bubbleSortByPower(home3);
        Home actual = home3;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testReplace() {
        Equipment[] expected = {television, microwave};
        Equipment[] actual = {microwave, television};
        Sorter.replace(actual, 0);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testReplaceNullArr(){
        Equipment[] expected = null;
        Equipment[] actual = null;
        Sorter.replace(actual, 0);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testReplaceNegativeIndex(){
        Equipment[] expected = {television, microwave};
        Equipment[] actual = {television, microwave};
        Sorter.replace(actual, -1);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testReplaceOutOfBoundArr(){
        Equipment[] expected = {television, microwave};
        Equipment[] actual = {television, microwave};
        Sorter.replace(actual, 3);

        Assert.assertEquals(expected, actual);
    }

}
