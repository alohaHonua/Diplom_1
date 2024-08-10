import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    private Bun bun;
    private final String expectedBunName;
    private final float expectedBunPrice;

    public BunTest(String expectedBunName, float expectedBunPrice) {
        this.expectedBunName = expectedBunName;
        this.expectedBunPrice = expectedBunPrice;
    }

    @Parameterized.Parameters(name = "название булки: {0}, цена булки: {1}")
    public static Object[][] getDataBun() {
        return new Object[][]{
                {"Stellar burger", 205.5F},
                {"", 115.5F},   // без названия
                {"Big burger", -105.0F}   // отрицательная стоимость
        };
    }

    @Before
    public void createObject() {
        bun = new Bun(expectedBunName, expectedBunPrice); // Создать булку
    }

    @Test
    public void getBunNameTest() {
        String actualBunName = bun.getName();
        assertEquals("Некорректное название булки", expectedBunName, actualBunName); // Проверка названия булки
    }

    @Test
    public void getBunPriceTest() {
        float actualBunPrice = bun.getPrice();
        assertEquals("Некорректная цена булки", expectedBunPrice, actualBunPrice, 0.0001); // Проверка цены булки
    }
}
