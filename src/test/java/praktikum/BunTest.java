package praktikum;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class BunTest {

    private Bun bun;

    @Before
    public void CreatBun(){
        bun = new Bun("Sesame Bun", 2.5f);
    }

    @Test
    public void testBunInitialization() {
        // Проверяем, что поля инициализированы корректно
        assertEquals("Sesame Bun", bun.name);
        assertEquals(2.5f, bun.price, 0.001); // delta для сравнения float
    }
    @Test
    public void testGetName() {
        // Проверяем, что метод getName возвращает правильное значение
        assertEquals("Sesame Bun", bun.getName());
    }
    @Test
    public void testGetPrice() {

        // Проверяем, что метод getName возвращает правильное значение
        assertEquals(2.5f, bun.getPrice(), 0.001);
    }
}
