package by.epam.javatraning.aksenov.task1.model.logic;

import by.epam.javatraning.aksenov.task1.model.entity.*;
import by.epam.javatraning.aksenov.task1.model.entity.container.HomeArray;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SorterTest {
    private HomeArray home1;
    private HomeArray home2;
    private HomeArray home3;
    private HomeArray home4;

    @BeforeTest
    public void setHome() {
        Lamp lamp1 = new Lamp(120.5, 60, true, 2);
        Microwave microwave = new Microwave(560, 650, false, 15);
        Television television = new Television(890.5, 120, true, 21);
        Lamp lamp2 = new Lamp(110, 80, false, 3);

        Equipment[] equipment1 = new Equipment[]{lamp1, microwave, television, lamp2};
        Equipment[] equipment2 = new Equipment[]{microwave, television, lamp2, lamp1};
        Equipment[] equipment3 = new Equipment[]{};

        home1 = new HomeArray(equipment1);
        home2 = new HomeArray(equipment2);
        home3 = new HomeArray(equipment3);
        home4 = null;
    }

    @Test
    public void testBubbleSortByPower() {
        HomeArray expected = home2;
        Sorter.bubbleSortByPower(home1);
        HomeArray actual = home1;

        assertEquals(expected, actual);
    }

    @Test
    public void testBubbleSortByPowerNullPtr(){
        HomeArray expected = home4;
        Sorter.bubbleSortByPower(home4);
        HomeArray actual = home4;

        assertEquals(expected, actual);
    }

    @Test
    public void testBubbleSortByPowerEmptyArr(){
        HomeArray expected = home3;
        Sorter.bubbleSortByPower(home3);
        HomeArray actual = home3;

        assertEquals(expected, actual);
    }
}
