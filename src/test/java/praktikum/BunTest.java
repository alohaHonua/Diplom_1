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
    public static Object[][] getData() {
        return new Object[][]{
                {"Булочка для бургера", 100.0f},
                {"Черная булочка", 150.0f},
                {"Безглютеновая булочка", 200.0f}
        };
    }

    @Test
    public void testCreateBunWithCorrectNameAndPrice() {
        Bun bun = new Bun(name, price);
        assertEquals(name, bun.getName());
        assertEquals(price, bun.getPrice(), 0.0f);
    }

    @Test
    public void testReturnCorrectNameFromGetter() {
        Bun bun = new Bun(name, price);
        assertEquals(name, bun.getName());
    }

    @Test
    public void testReturnCorrectPriceFromGetter() {
        Bun bun = new Bun(name, price);
        assertEquals(price, bun.getPrice(), 0.0f);
    }
}
