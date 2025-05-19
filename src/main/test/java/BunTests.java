import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTests {
    private String name;
    private float price;
    private Bun bun;

    public BunTests(String name, float price) {
        this.name = name;
        this.price = price;
    }
    @Parameterized.Parameters(name = "Bun named {0} for {1} money" )
    public static Object[][] getParameters() {
        return new Object[][] {
                {"black bun", 100.0F},
                {"white bun", 200.0F},
                {"red bun", 300.0F}
        };
    }

    @Before
    public void createBun() {
        this.bun = new Bun(name, price);
    }

    @Test
    public void getNameTest() {
        String actualName = bun.getName();
        assertEquals("Bun name expected: " + name + ", actual name: " + actualName, name, actualName);
    }
    @Test
    public void getPriceTest() {
        float actualPrice = bun.getPrice();
        assertEquals("Bun price expected: " + price + ", actual price: " + actualPrice, price, actualPrice, 0);
    }
}


