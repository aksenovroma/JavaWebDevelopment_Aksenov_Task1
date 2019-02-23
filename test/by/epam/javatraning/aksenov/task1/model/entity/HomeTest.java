package by.epam.javatraning.aksenov.task1.model.entity;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomeTest {
    private Home home1;
    private Equipment[] equipment1;
    private Equipment[] equipment2;
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

        equipment1 = new Equipment[]{lamp1, microwave, television};
        equipment2 = new Equipment[]{lamp1, microwave, television, lamp2};

        home1 = new Home(equipment1);
    }

    @Test
    public void constructorHomeTest() {
        Home testHome1 = new Home(equipment1);
        Home testHome2 = new Home(null);

        Equipment[] expected1 = equipment1;
        Equipment[] actual1 = testHome1.getEquipment();

        Equipment[] expected2 = null;
        Equipment[] actual2 = testHome2.getEquipment();

        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void setEquipmentTest() {
        home1.setEquipment(null);
    }

    @Test
    public void addTest() {
        Home expected1 = new Home(equipment2);
        Home actual1 = new Home(equipment1);

        actual1.add(lamp2);

        Assert.assertEquals(expected1, actual1);
    }

    @Test
    public void atHomeTest() {
        boolean actual1 = home1.atHome(lamp1);
        boolean actual2 = home1.atHome(lamp2);
        boolean actual3 = home1.atHome(null);

        Assert.assertTrue(actual1);
        Assert.assertFalse(actual2);
        Assert.assertFalse(actual3);
    }

    @Test
    public void removeTest() {
        Home expected1 = new Home(equipment1);
        Home actual1 = new Home(equipment2);

        actual1.remove(lamp2);

        Assert.assertEquals(expected1, actual1);

        Home expected2 = new Home(equipment1);
        Home actual2 = new Home(equipment2);

        actual2.remove(lamp2);

        Assert.assertEquals(expected2, actual2);
    }
}
