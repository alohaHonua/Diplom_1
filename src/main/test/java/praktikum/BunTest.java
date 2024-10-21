package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

// Создаем класс BunTest, который будет содержать тесты для класса Bun
public class BunTest {
    private Bun bun;

    // Метод createNewInstance будет вызываться перед каждым тестом
    // Создаю новый объект класса Bun с именем "original" и ценой 200.0
    @Before
    public void createNewInstance() {
        bun = new Bun("original", 200.0f);
    }

    // Тестирование метода получения имени, ожидаемое имя должно совпадать с фактической
    @Test
    public void getName() {
        String expected = "original";
        String actual = bun.getName();

        assertEquals("Incorrect values bun name", expected, actual);
    }

    // Тестирование метода получения цены, ожидаемая цена должна совпадать с фактической
    @Test
    public void getPrice() {
        float expected = 200.0f;
        float actual = bun.getPrice();

        assertEquals("Incorrect values bun price", expected, actual, 0);
    }
}