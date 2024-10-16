package praktikum.bun;

import org.junit.Test;
import praktikum.Bun;
import praktikum.TestConstants;

import static org.junit.Assert.assertThrows;

public class BunNegativeTest {

    // Создание булочки с отрицательной ценой должно выбросить исключение
    @Test
    public void testCreateBunWithNegativePrice() {
        assertThrows(IllegalArgumentException.class, () ->
                new Bun(TestConstants.BLACK_BUN_NAME, TestConstants.INVALID_PRICE));
    }
}
