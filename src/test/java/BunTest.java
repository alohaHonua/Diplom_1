import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {

    @Test
    public void testGetName() {
        // Тест на проверку корректного получения имени булочки
        String expectedName = "white bun";
        Bun bun = new Bun(expectedName, 200);
        assertEquals(expectedName, bun.getName());
    }

    @Test
    public void testGetPrice() {
        // Тест на проверку корректного получения цены булочки
        float expectedPrice = 200.0f;
        Bun bun = new Bun("white bun", expectedPrice);
        assertEquals(expectedPrice, bun.getPrice(), 0.0);
    }
}
