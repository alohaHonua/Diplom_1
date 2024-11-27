import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)

public class BunTest {

    public Bun bun;

    @Parameterized.Parameter
    public String name;

    @Parameterized.Parameter(1)
    public float price;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"black bun", 100},
                {"white bun", 200},
                {"red bun", 300},
        };
    }

    @Before
    public void setUp() {
        bun = new Bun(name, price);
    }

    @Test
    public void getNameForBunTest() {
        assertEquals(name, bun.getName());
    }

    @Test
    public void getPriceForBunTest() {
        assertEquals(price, bun.getPrice(), 0.001);
    }
}
