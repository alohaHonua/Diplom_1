package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.enums.Buns;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunParameterizedTest {
    private final String name;
    private final float price;

    public BunParameterizedTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "name: \"{0}\", price: {1}")
    public static Object[][] getBuns() {
        return new Object[][]{
                {Buns.FLU_BUN.getName(), Buns.FLU_BUN.getPrice()},
                {Buns.CRATOR_BUN.getName(), Buns.CRATOR_BUN.getPrice()},
        };
    }

    @Test
    public void checkBuns() {
        Bun bun = new Bun(name, price);
        assertEquals("Ошибка в имени булки", name, bun.getName());
        assertEquals("Ошибка в цене булки", price, bun.getPrice(),0);
    }
}
