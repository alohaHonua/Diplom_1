package unit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunParametrizedTest {

    private final String name;
    private final float price;
    private final Bun bun;

    public BunParametrizedTest(String name, float price) {
        this.name = name;
        this.price = price;
        this.bun = new Bun(name, price);
    }

    @Parameterized.Parameters(name = "Bun: name={0}, price={1}")
    public static Object[][] getBunData() {
        return new Object[][]{
                {"black bun", 100.0f},
                {"white bun", 200.5f},
                {"red bun", 0.0f},
                {"", 50.0f},
                {"special_bun !@#", -50.0f}
        };
    }

    @Test
    public void getNameShouldReturnCorrectName() {
        assertEquals("The name of the bun must match the specified one.", name, bun.getName());
    }

    @Test
    public void getPriceShouldReturnCorrectPrice() {
        assertEquals("The price of the bun must match the set price.", price, bun.getPrice(), 0.0f);
    }
}
