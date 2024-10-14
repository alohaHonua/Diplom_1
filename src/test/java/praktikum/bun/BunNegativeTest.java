package praktikum.bun;

import org.junit.Test;
import praktikum.Bun;

public class BunNegativeTest {

    // Тест: создание булочки с отрицательной ценой должно выбросить исключение
    @Test(expected = IllegalArgumentException.class)
    public void testCreateBunWithNegativePrice() {
        new Bun("Invalid Bun", -50);
    }

    // Тест: создание булочки с пустым именем должно выбросить исключение
    @Test(expected = IllegalArgumentException.class)
    public void testCreateBunWithEmptyName() {
        new Bun("", 100);
    }
}
