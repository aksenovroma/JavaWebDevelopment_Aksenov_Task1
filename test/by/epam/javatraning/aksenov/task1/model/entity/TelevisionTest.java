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
    public void testConstructorTelevision() {
        Television television = new Television(120, 60, true, 19);

        double expected1 = 19;
        double actual1 = television.getDiagonal();

        Assert.assertEquals(expected1, actual1);
    }

    @Test
    public void testConstructorTelevisionNegativeArg() {
        Television television = new Television(120, 60, true, -19);

        double expected = 0;
        double actual = television.getDiagonal();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testConstructorTelevisionCopier() {
        Television televisionCopy = new Television(television, 22);

        double expected = 22;
        double actual = televisionCopy.getDiagonal();

        Assert.assertEquals(expected, actual);
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
