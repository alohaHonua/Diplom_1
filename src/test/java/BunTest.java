
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.*;

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
        return new Object[][] {
                {"black bun", 100.0f},
                {"white bun", 200.0f},
                {"red bun", 300.0f},
                {"", 0.0f},
                {" ", 0.01f},
                {"special@bun", 999.99f},
                {"very long bun name that exceeds normal length", Float.MAX_VALUE}
        };
    }

    @Test
    public void testBunConstructorAndGetName() {
        Bun bun = new Bun(name, price);
        assertEquals("Название булочки должно совпадать с переданным в конструктор",
                name, bun.getName());
    }

    @Test
    public void testGetPrice() {
        Bun bun = new Bun(name, price);
        assertEquals("Цена булочки должна совпадать с переданной в конструктор",
                price, bun.getPrice(), 0.0f);
    }

    @Test
    public void testBunWithNullName() {
        Bun bun = new Bun(null, 100.0f);
        assertNull("Конструктор должен принимать null в качестве названия", bun.getName());
    }

    @Test
    public void testBunWithNegativePrice() {
        Bun bun = new Bun("negative price bun", -1.0f);
        assertEquals("Конструктор должен принимать отрицательную цену",
                -1.0f, bun.getPrice(), 0.0f);
    }
}