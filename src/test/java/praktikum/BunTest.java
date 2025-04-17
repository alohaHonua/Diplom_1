package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    private final String name;
    private final float price;
    private final Bun bun;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
        this.bun = new Bun(name, price);
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
            {"black bun", 100},
            {"white bun", 200},
            {"red bun", 300}
        };
    }

    @Test
    public void testGetName() {
        assertEquals(name, bun.getName());
    }

    @Test
    public void testGetPrice() {
        assertEquals(price, bun.getPrice(), 0.0f);
    }
} 