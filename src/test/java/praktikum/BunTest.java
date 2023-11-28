package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;
import static praktikum.constants.Constants.*;


@RunWith(Parameterized.class)
public class BunTest {
    private final String name;
    private final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getIngredientData() {
        return new Object[][] {
                {BUN_FLUORESCENT, 100},
                {BUN_KATOR, 0},
                {BUN_FLUORESCENT, -100},
                {EMPTY_STRING, 200},
                {SPECIAL_CHARACTER_STRING, 200},
                {null, 200},
        };
    }

    @Test
    public void getNameSuccess() {
        Bun bun = new Bun(name, price);
        assertEquals(
                name,
                bun.getName());
    }

    @Test
    public void getPriceSuccess()  {
        Bun bun = new Bun(name, price);
        assertEquals(
                price,
                bun.getPrice(), 0);
    }
}
