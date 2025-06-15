import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class BunTest {

    private final String expectedName;
    private final float expectedPrice;

    public BunTest(String name, float price) {
        this.expectedName = name;
        this.expectedPrice = price;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getData() {
        return Arrays.asList(new Object[][]{
                {"Белая булочка", 1.0f},
                {"Булочка с кунжутом", 2.5f},
                {"Чёрная булочка", 0.99f}
        });
    }

    @Test
    public void testBunGetters() {
        Bun bun = new Bun(expectedName, expectedPrice);
        assertEquals("Название булочки не совпадает", expectedName, bun.getName());
        assertEquals("Цена булочки не совпадает", expectedPrice, bun.getPrice(), 0.001f);
    }
}
