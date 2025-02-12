import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    private final String name;
    private final float price;
    private Bun bun;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Название и цена булочки: {0}: {1}")
    public static Object[][] getBunData() {
        return new Object[][]{
                {"Краторная булка N-200i", Float.MIN_VALUE},
                {"Флюоресцентная булка R2-D3", Float.MAX_VALUE},
                {" ", 1234},
                {null, -123},
                {"Zero price bun", 0.0f},
                {"Обычная булка", 100.50f}
        };
    }

    @Before
    public void setUp() {
        bun = new Bun(name, price);
    }

    @Test
    public void getNameTest() {
        assertEquals("Значение Имя не верное",name, bun.getName());
    }

    @Test
    public void getPriceTest() {
        assertEquals("Значение Цена не верное", price, bun.getPrice(), 0);
    }

}