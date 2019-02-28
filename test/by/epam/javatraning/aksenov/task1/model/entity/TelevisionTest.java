package by.epam.javatraning.aksenov.task1.model.entity;

import by.epam.javatraning.aksenov.task1.model.exception.NegativeArgumentException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TelevisionTest {
    private Television television;

    @BeforeTest
    public void setLamp() {
        television = new Television(120.5, 60, true, 20);
    }

    @Test
    public void constructorTelevisionTest() {
        Television lamp1 = new Television(120, 60, true, 19);
        Television lamp2 = new Television(120, 60, true, -19);
        Television lamp3 = new Television(lamp1, 22);

        double expected1 = 19;
        double actual1 = lamp1.getDiagonal();

        double expected2 = 0;
        double actual2 = lamp2.getDiagonal();

        double expected3 = 22;
        double actual3 = lamp3.getDiagonal();

        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
        Assert.assertEquals(expected3, actual3);
    }

    @Test(expectedExceptions = NegativeArgumentException.class)
    public void setDiagonal() {
        double expected = 21;

        television.setDiagonal(21);

        double actual = television.getDiagonal();

        Assert.assertEquals(expected, actual);

        television.setDiagonal(-10);
    }
}
