package praktikum;

import io.qameta.allure.junit4.DisplayName;
import junit.framework.TestCase;
import org.junit.Test;

public class BunTest extends TestCase {

    private static final String NAME = "Black bun";
    private static final float PRICE = 10f;
    private static final Bun BUN = new Bun(NAME, PRICE);

    @Test
    @DisplayName("тест геттера для атрибута \"имя\"")
    public void testGetName() {
        assertEquals(String.format("Ожидаемое имя: \"%s\", а получилось: \"%s\"", NAME, BUN.getName()), NAME, BUN.getName());
    }

    @Test
    @DisplayName("тест геттера для атрибута \"цена\"")
    public void testGetPrice() {
        assertEquals(String.format("Ожидаемая цена: %.2f, а получилась: %.2f", PRICE, BUN.getPrice()), PRICE, BUN.getPrice());
    }
}