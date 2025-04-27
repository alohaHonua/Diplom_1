package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * Тестирование класса Bun.
 * Проверяется корректность инициализации объекта Bun с различными параметрами.
 */
@RunWith(Parameterized.class)
public class BunTest {

    private final String bunName;
    private final float bunPrice;

    public BunTest(String bunName, float bunPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"sesame bun", 120},
                {"potato bun", 180},
                {"gluten-free bun", 220}
        };
    }

    @Test
    public void testBunAttributes() {
        Bun bun = new Bun(bunName, bunPrice);
        Assert.assertEquals(bunName, bun.getName());
        Assert.assertEquals(bunPrice, bun.getPrice(),0.01);
    }
}