package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {

    private final String name;
    private final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameters(name = "name={0}, price={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
            { "black bun", 100f },
            { "white bun", 200f },
            { "red bun", 150f }
        });
    }

    @Test
    public void testBunConstructor() {
        Bun bun = new Bun(name, price);
        assertEquals("Название булочки должно совпадать", name, bun.getName());
        assertEquals("Цена булочки должна совпадать", price, bun.getPrice(), 0.0f);
    }

    @Test
    public void testBunGetters() {
        Bun bun = new Bun("white bun", 200f);
        assertEquals("Метод getName должен возвращать правильное название", "white bun", bun.getName());
        assertEquals("Метод getPrice должен возвращать правильную цену", 200, bun.getPrice(), 0.0f);
    }
} 