package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunParameterizedTest {
    private final String name;
    private final float price;

    public BunParameterizedTest(String name, float price) {
        this.name = name;
        this.price = price;
    }
    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][]{
                {"Флюоресцентная булка R2-D3", 988.0f},
                {"Краторная булка N-200i", 1255.0f}
        };
}
    @Test
    public void testNameBun() {
        Bun bun = new Bun(name, price);
        Assert.assertEquals(name, bun.getName());
    }
    @Test
    public void testPriceBun() {
        Bun bun = new Bun(name, price);
        Assert.assertEquals(price, bun.getPrice(), 0);
    }
}
