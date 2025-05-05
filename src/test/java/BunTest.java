import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class BunTest {

    private final String expectedName;
    private final float expectedPrice;
    private Bun bun;

    public BunTest(String expectedName, float expectedPrice) {
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters(name = "{index}: Bun name: \"{0}\", price: {1}")
    public static Collection<Object[]> getTestData() {
        return Arrays.asList(new Object[][] {
                {"cheese bun", Float.MAX_VALUE}, // Макисмальное значение для цены
                {"green bun", -Float.MAX_VALUE}, // Минимальное значение для цены
                {"", 0.0f}, // Пустое наименование, нулевая цена
                {"special@ Bun#1", 9.99f} // Спец символы в наименовании
        });
    }

    @Before
    public void setUp() {
        bun = new Bun(expectedName, expectedPrice);
    }

    @Test
    public void testBunGetName() {
        assertEquals("Название булочки не совпадает", expectedName, bun.getName());
    }

    @Test
    public void testBunGetPrice() {
        assertEquals("Цена булочки не совпадает", expectedPrice, bun.getPrice(), 0.0001f);
    }
}