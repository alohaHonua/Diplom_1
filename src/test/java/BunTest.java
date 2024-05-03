import praktikum.Bun;
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

    @Parameterized.Parameters(name = "Bun: {0}, Price: {1}")
    public static Object[][] getParameters() {
        return new Object[][]{
                {"generic bun", 100},
                {"123456", 75},
                {"", 50},
                {"!&!&$?", 40},
                {"булка", 35},
                {null, 25},
                {"abcdef", -100},
                {"fedcba", 20.111222333f}
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