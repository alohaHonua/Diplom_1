import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

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
    public static Object[][] getData() {
        return new Object[][] {
                {"hot sauce", 100},
                {"sour cream", 200},
                {"chili sauce", 300},
                {"cutlet", 100},
                {"dinosaur", 200},
                {"sausage", 300}
        };
    }

    @Test
    public void getNameTest() {
        Bun bun = new Bun(name, price);
        assertEquals(name, bun.getName());
    }

    @Test
    public void getPriceTest() {
        Bun bun = new Bun(name, price);
        assertEquals(price, bun.getPrice(), 0);
    }
}
