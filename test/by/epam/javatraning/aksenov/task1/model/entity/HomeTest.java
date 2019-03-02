package by.epam.javatraning.aksenov.task1.model.entity;

import by.epam.javatraning.aksenov.task1.model.exception.HomeEquipmentWrongException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

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
    public void testConstructorHome() {
        Home testHome = new Home(equipment1);

        Equipment[] expected = equipment1;
        Equipment[] actual = testHome.getEquipment();

        assertEquals(expected, actual);
    }

    @Test
    public void testConstructorHomeNullArr() {
        Home testHome = new Home(null);

        Equipment[] expected = null;
        Equipment[] actual = testHome.getEquipment();

        assertEquals(expected, actual);
    }

    @Test
    public void testSetEquipment() throws HomeEquipmentWrongException {
        Home expected = home1;
        Home actual = new Home(equipment2);

        actual.setEquipment(equipment1);

        assertEquals(expected, actual);
    }

    @Test(expectedExceptions = HomeEquipmentWrongException.class)
    public void testSetEquipmentWrong() throws HomeEquipmentWrongException {
        home1.setEquipment(null);
    }

    @Test
    public void testAdd() {
        Home expected = new Home(equipment2);
        Home actual = new Home(equipment1);

        actual.add(lamp2);

        assertEquals(expected, actual);
    }

    @Test
    public void testAddNullPtr() {
        Home expected = new Home(equipment2);
        Home actual = new Home(equipment2);

        actual.add(null);

        assertEquals(expected, actual);
    }

    @Test
    public void testAtHome() {
        boolean actual = home1.atHome(lamp1);

        assertTrue(actual);
    }

    @Test
    public void testAtHomeNullPtr() {
        boolean actual = home1.atHome(null);

        assertFalse(actual);
    }

    @Test
    public void testAtHomeFalse() {
        boolean actual = home1.atHome(lamp2);

        assertFalse(actual);
    }

    @Test
    public void testRemove() {
        Home expected = new Home(equipment1);
        Home actual = new Home(equipment2);

        actual.remove(lamp2);

        assertEquals(expected, actual);
    }

    @Test
    public void testRemoveNullPtr() {
        Home expected = new Home(equipment2);
        Home actual = new Home(equipment2);

        actual.remove(null);

        assertEquals(expected, actual);
    }

    @Test
    public void testRemoveNotAtHome() {
        Home expected2 = new Home(equipment1);
        Home actual2 = new Home(equipment2);

        actual2.remove(lamp2);

        assertEquals(expected2, actual2);
    }
}
