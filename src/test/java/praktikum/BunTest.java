package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Тесты для класса Bun (булочка для бургера).
 * Проверяют корректность работы методов getName() и getPrice().
 */

@RunWith(Parameterized.class) // Используем параметризованные тесты
public class BunTest {
    private final String name;
    private final float price;

    /**
     * Конструктор для параметризованных тестов
     * @param name - название булочки
     * @param price - цена булочки
     */

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Метод предоставляет тестовые данные для параметризованных тестов.
     */

    @Parameterized.Parameters(name = "Тест #{index}: Булочка {0} с ценой {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"black bun", 100},   // Тест-кейс 1: черная булочка, цена 100
                {"white bun", 200},   // Тест-кейс 2: белая булочка, цена 200
                {"red bun", 300}      // Тест-кейс 3: красная булочка, цена 300
        });
    }

    /**
     * Тест проверяет корректность получения названия булочки.
     * Создает булочку с заданными параметрами и проверяет,
     * что метод getName() возвращает ожидаемое значение.
     */
    @Test
    public void testGetName() {
        // Arrange (подготовка)
        Bun bun = new Bun(name, price);

        // Act (действие)
        String actualName = bun.getName();

        // Assert (проверка)
        assertEquals("Название булочки должно совпадать с заданным в конструкторе",
                name, actualName);
    }

    /**
     * Тест проверяет корректность получения цены булочки.
     * Создает булочку с заданными параметрами и проверяет,
     * что метод getPrice() возвращает ожидаемое значение.
     */
    @Test
    public void testGetPrice() {
        // Arrange (подготовка)
        Bun bun = new Bun(name, price);

        // Act (действие)
        float actualPrice = bun.getPrice();

        // Assert (проверка)
        assertEquals("Цена булочки должна совпадать с заданной в конструкторе",
                price, actualPrice, 0.01);
    }
}