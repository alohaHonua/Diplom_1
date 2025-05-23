import org.junit.*;
import static org.junit.Assert.*;

import praktikum.Bun;

public class BunTest {
    private static final String TEST_BUN_NAME = "Флуоресцентная булка R2-D3";
    private static final float TEST_BUN_PRICE = 988.0f;
    private static final float DELTA = 0.001f;

    private Bun bun;

    @Before
    public void setUp() {
        bun = new Bun(TEST_BUN_NAME, TEST_BUN_PRICE);
    }

    @Test // проверяет, что метод getName() возвращает корректное название булки, переданное в конструктор
    public void testGetName() {
        assertEquals("Название булочки, переданное в конструктор, не совпадает",
                TEST_BUN_NAME, bun.getName());
    }

    @Test // проверяет, что метод getPrice() возвращает корректную цену булки, переданную в конструктор
    public void testGetPrice() {
        assertEquals("Цена булочки, переданная в конструктор, не совпадает",
                TEST_BUN_PRICE, bun.getPrice(), DELTA);
    }
}