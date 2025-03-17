import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.*;

public class BunTest {

    private Bun bun;

    @Before
    public void setUp() {
        // Инициализация объекта Bun перед каждым тестом
        bun = new Bun("Sesame Bun", 1.5f);
    }

    @Test
    public void testGetName() {
        // Проверяем, что метод getName возвращает правильное имя
        assertEquals("Sesame Bun", bun.getName());
    }

    @Test
    public void testGetPrice() {
        // Проверяем, что метод getPrice возвращает правильную цену
        assertEquals(1.5f, bun.getPrice(), 0.01);
    }

    @Test
    public void testBunConstructor() {
        // Проверяем, что конструктор правильно инициализирует поля
        assertNotNull(bun);
        assertEquals("Sesame Bun", bun.getName());
        assertEquals(1.5f, bun.getPrice(), 0.01);
    }
}