package praktikum.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;
import static praktikum.constants.Constants.*;

@RunWith(Parameterized.class)
public class BunTest {

    private final String name;
    private final float price;
    private Bun bun;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Булочка: ({0}), Цена: {1}")
    public static Object[] getBunData() {
        return new Object[][]{
                {BLACK_BUN, PRICE_100f},
                {WHITE_BUN, PRICE_200f},
                {RED_BUN, PRICE_300f},
        };
    }

    @Before
    public void setUp() {
        bun = new Bun(name, price);
    }

    @Test
    public void testGetPriceOfBun() {

        assertEquals("Получаем цену булочке", price, bun.getPrice(), DELTA);
    }

    @Test
    public void testGetNameOfBun() {
        assertEquals("Получаем название модели",name, bun.getName());
    }
}
