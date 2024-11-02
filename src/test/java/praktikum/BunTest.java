package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BunTest {
    private Bun bun;
    private final String name;
    private final float price;
    private final static double DELTA = 0.0f;

    @Before
    public void beforeBunTest() {
        bun = new Bun(name, price);
    }

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters()
    public static Object[][] getNameAndPrice() {
        return new Object[][] {
                {"Ржаная булочка", (float) 100},
                {"123321", (float) 84.19},
                {null, (float) 0},
                {"Burger bun", (float) -12.6}
        };
    }

    @Test
    public void getNameTest() {
        assertEquals("Название булочки не совпадает с ожидаемым результатом", name, bun.getName());
    }

    @Test
    public void getPriceTest() {
        assertEquals("Цена булочки не совпадает с ожидаемым результатом", price, bun.getPrice(), DELTA);
    }
}