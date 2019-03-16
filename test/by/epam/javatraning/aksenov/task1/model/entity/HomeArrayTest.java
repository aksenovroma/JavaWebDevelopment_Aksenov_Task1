package by.epam.javatraning.aksenov.task1.model.entity;

import by.epam.javatraning.aksenov.task1.model.entity.container.Home;
import by.epam.javatraning.aksenov.task1.model.entity.container.HomeArray;
import by.epam.javatraning.aksenov.task1.model.exception.logic.HomeEquipmentWrongException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class HomeArrayTest {
    private HomeArray home1;
    private Equipment[] equipment1;
    private Equipment[] equipment2;
    private Lamp lamp1;
    private Lamp lamp2;

    @BeforeMethod
    public void setHome() {
        Microwave microwave = new Microwave(560, 650, false, 15);
        Television television = new Television(890.5, 120, true, 21);
        lamp1 = new Lamp(120.5, 60, true, 2);
        lamp2 = new Lamp(110, 80, false, 3);

        equipment1 = new Equipment[]{lamp1, microwave, television};
        equipment2 = new Equipment[]{lamp1, microwave, television, lamp2};

        home1 = new HomeArray(equipment1);
    }

    @Test
    public void testConstructorHome() {
        HomeArray testHome = new HomeArray(equipment1);

        Equipment[] expected = equipment1;
        Equipment[] actual = testHome.getEquipment();

        assertEquals(expected, actual);
    }

    @Test
    public void testConstructorHomeNullArr() {
        HomeArray testHome = new HomeArray(null);

        Equipment[] expected = new Equipment[0];
        Equipment[] actual = testHome.getEquipment();

        assertEquals(expected, actual);
    }

    @Test
    public void testGetEquipment() {
        Equipment[] expected = equipment1;
        Equipment[] actual = home1.getEquipment();

        assertEquals(expected, actual);
    }

    @Test
    public void testGet() {
        Equipment expected = lamp1;
        Equipment actual = home1.get(0);

        assertEquals(expected, actual);
    }

    @Test
    public void testGetWrongIndex() {
        Equipment expected = null;
        Equipment actual = home1.get(3);

        assertEquals(expected, actual);
    }

    @Test
    public void testIsEmpty() {
        Equipment[] equipment = new Equipment[0];
        Home home = new HomeArray(equipment);

        assertFalse(home1.isEmpty());
        assertTrue(home.isEmpty());
    }

    @Test
    public void testSize() {
        int expected = 3;
        int actual = home1.size();

        assertEquals(expected, actual);
    }

    @Test
    public void testSetEquipment() throws HomeEquipmentWrongException {
        HomeArray expected = home1;
        HomeArray actual = new HomeArray(equipment2);

        actual.setEquipment(equipment1);

        assertEquals(expected, actual);
    }

    @Test(expectedExceptions = HomeEquipmentWrongException.class)
    public void testSetEquipmentWrong() throws HomeEquipmentWrongException {
        home1.setEquipment(null);
    }

    @Test
    public void testAdd() {
        HomeArray expected = new HomeArray(equipment2);
        HomeArray actual = new HomeArray(equipment1);

        actual.add(lamp2);

        assertEquals(expected, actual);
    }

    @Test
    public void testAddNullPtr() {
        HomeArray expected = new HomeArray(equipment2);
        HomeArray actual = new HomeArray(equipment2);

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
        HomeArray expected = new HomeArray(equipment1);
        HomeArray actual = new HomeArray(equipment2);

        actual.remove(lamp2);

        assertEquals(expected, actual);
    }

    @Test
    public void testRemoveNullPtr() {
        HomeArray expected = new HomeArray(equipment2);
        HomeArray actual = new HomeArray(equipment2);

        actual.remove(null);

        assertEquals(expected, actual);
    }

    @Test
    public void testRemoveNotAtHome() {
        HomeArray expected = new HomeArray(equipment1);
        HomeArray actual = new HomeArray(equipment2);

        actual.remove(lamp2);

        assertEquals(expected, actual);
    }

    @Test
    public void testEquals() {
        HomeArray home2 = new HomeArray(equipment1);

        boolean actual = home1.equals(home2);

        assertTrue(actual);
    }

    @Test
    public void testEqualsDifferentEquipment() {
        HomeArray home2 = new HomeArray(equipment2);

        boolean actual = home1.equals(home2);

        assertFalse(actual);
    }

    @Test
    public void testEqualsSameObject() {
        boolean actual = home1.equals(home1);

        assertTrue(actual);
    }

    @Test
    public void testEqualsNullPtr() {
        HomeArray home2 = null;

        boolean actual = home1.equals(home2);

        assertFalse(actual);
    }

    @Test
    public void testEqualsOtherClass() {
        Object o = new Object();

        boolean actual = home1.equals(o);

        assertFalse(actual);
    }

    @Test
    public void testHashCode() {
        HomeArray home2 = new HomeArray(equipment1);

        boolean actual = (home1.hashCode() == home2.hashCode());

        assertTrue(actual);
    }

    @Test
    public void testHashCodeWrong() {
        HomeArray home2 = new HomeArray(equipment2);

        boolean actual = (home1.hashCode() == home2.hashCode());

        assertFalse(actual);
    }

    @Test
    public void testHashCodeSameObject() {
        HomeArray home2 = home1;

        boolean actual = (home1.hashCode() == home2.hashCode());

        assertTrue(actual);
    }

    @Test
    public void testToString() {
        String expected = "Home{equipment=[Lamp{price=120.5, power=60.0, selector=true, lightbulb=2}, " +
                "Microwave{price=560.0, power=650.0, selector=false, volume=15.0}, " +
                "Television{price=890.5, power=120.0, selector=true, diagonal=21.0}]}";
        String actual = home1.toString();

        assertEquals(expected, actual);
    }
}
