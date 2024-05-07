package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class BunTest {

    private final Bun bun;
    private final String expectedName;
    private final float expectedPrice;

    public BunTest(String name, float price) {
        this.expectedName = name;
        this.expectedPrice = price;
        this.bun = new Bun(name, price);
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Обычная булка", 100f},
                {"Черная булка", 120f},
                {"Сырная булка", 130f}
        });
    }

    @Test
    public void testGetName() {
        assertEquals(expectedName, bun.getName());
    }

    @Test
    public void testGetPrice() {
        assertEquals(expectedPrice, bun.getPrice(), 0.001);
    }
}
