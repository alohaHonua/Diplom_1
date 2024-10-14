package praktikum.bun;

import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {

    // Тест: проверка получения имени булочки
    @Test
    public void testGetBunName() {
        Bun bun = new Bun("Black Bun", 100);
        assertEquals("Black Bun", bun.getName());
    }

    // Тест: проверка получения цены булочки
    @Test
    public void testGetBunPrice() {
        Bun bun = new Bun("White Bun", 150);
        assertEquals(150, bun.getPrice(), 0.01);
    }


}
