package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    private final String name;
    private final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {"Булочка с белым кунжутом", 111.33f},
                {"Булочка с черным кунжутом", 223.6f},
                {"Черная булочка", 0.111f}
        };
    }

    // Создаем булочку и проверяем, что название и цена булочки совпадает.
    @Test
    public void returnsCorrectBunValuesTest() {
        Bun bun = new Bun(name, price);
        assertEquals("Название булочки не совпадает", name, bun.getName());
        assertEquals("Неверная цена булочки", price, bun.getPrice(), 0.001f);
    }
}
