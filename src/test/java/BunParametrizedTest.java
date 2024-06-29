import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunParametrizedTest {

    private final String name;
    private final float price;

    public BunParametrizedTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] dataForTest() {
        return new Object[][]{
                {"classic bun", 100},
                {"sesame bun", 200},
                {"gluten-free bun", 300},
                {"", 150},
                {"superduperextrahugebighumongousbunname", 200},
                {null, 130},
                {"regular bun", -150},
                {"regular bun", 0},
                {"regular bun", 0.50f},
                {"regular bun", 1000000000},
                {"numbered 5678", 350},
                {"Cheap bun", Float.MIN_VALUE},
                {"Expensive bun", Float.MAX_VALUE},
        };
    }

    @Test
    public void getName() {
        Bun bun = new Bun(name, price);
        assertEquals("Неверное название булочки", name, bun.getName());
    }

    @Test
    public void getPrice() {
        Bun bun = new Bun(name, price);
        assertEquals("Неверная цена булочки", price, bun.getPrice(), 0.0f);
    }
}
