package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class BunTest {
    private static final float DELTA = 0.0001f; // Дельта для сравнения float
    private String name;
    private float price;
    private Bun bun;

    // Конструктор для параметризации
    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    // Параметризованный набор данных
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"white bun", 100},
                {"sesame bun", 120},
                {"", 150},
                {null, 150},
                {"zero price bun", 0},
                {"negative price bun", -50},
                {"premium bun", 1000000},
                {"max float price", Float.MAX_VALUE},
                {"min float price", Float.MIN_VALUE},
                {"NaN price", Float.NaN},
                {"infinity price", Float.POSITIVE_INFINITY},
                {"negative infinity price", Float.NEGATIVE_INFINITY}
        });
    }

    @Test
    public void testGetName() {
        bun = new Bun(name, price);
        assertEquals(name, bun.getName());
    }

    @Test
    public void testGetPrice() {
        bun = new Bun(name, price);
        assertEquals(price, bun.getPrice(), DELTA);
    }

    // Уникальный тест для проверки NaN
    @Test
    public void testPriceIsNaN() {
        if (Float.isNaN(price)) {
            bun = new Bun(name, price);
            assertTrue(Float.isNaN(bun.getPrice()));
        }
    }
}
