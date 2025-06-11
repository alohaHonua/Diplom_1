package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BunTest {
    private final String name;
    private final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Bun: {0}, Price: {1}")
    public static Object[][] data() {
        return new Object[][]{
                {"Краторная булка N-2001", 1255f},
                {"Флюоресцентная булка R2-D3", 988f}
        };
    }

    @Test
    public void bunNameIsReturnedCorrectly() {
        Bun bun = new Bun(name, price);
        assertEquals(name, bun.getName());
    }

    @Test
    public void bunPriceIsReturnedCorrectly() {
        Bun bun = new Bun(name, price);
        assertEquals(price, bun.getPrice(), 0.01);
    }
}