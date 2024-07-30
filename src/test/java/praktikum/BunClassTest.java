package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunClassTest {
    private final String name;
    private final float price;

    public BunClassTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Cinnamon Bun", 2.5f},
                {"Cinnamon Bun Double", 5.0f}
        });
    }

    @Test
    public void testGetName() {
        Bun bun = new Bun(name, price);
        assertEquals(name, bun.getName());
    }

    @Test
    public void testGetPrice() {
        Bun bun = new Bun(name, price);
        assertEquals(price, bun.getPrice(), TestUtils.DELTA); // Проверка с погрешностью 0.001 из-за работы с float
    }
}
