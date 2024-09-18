
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BunTests {

    Bun bun;
    private final String name;
    private final float price;

    public BunTests(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][] {
                {"black bun", 100},
                {"", 50.987654f},
                {"50.987654f", -1},
                {"!@#$@$@", 0}

        };
    }

    @Before
    public void setUp() {
        bun = new Bun(name, price);
    }

    @Test
    public void BunNameTest() {
        assertEquals("Поле name сохранилось некорректно",
                name, bun.getName());

    }

    @Test
    public void bunPriceTest() {
        assertEquals("Поле price сохранилось некорревтно",
                price, bun.getPrice() , 0.00001);

    }

}