package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

/**
 * Тесты для класса Bun.
 * В данном тесте используется параметризация для проверки корректности создания объекта Bun
 * с различными значениями параметров (имя булки и цена).
 */
@RunWith(Parameterized.class) // Эта аннотация указывает, что класс будет запускаться с использованием параметризации.
public class BunTest {

    private final Bun bun; // Экземпляр класса Bun, который будет тестироваться.

    /**
     * Конструктор теста. Он принимает параметры для создания объекта Bun.
     * JUnit будет автоматически передавать значения из метода getBun() в этот конструктор.
     *
     * @param nameBun  Имя булки.
     * @param priceBun Цена булки.
     */
    public BunTest(String nameBun, float priceBun) {
        // Инициализация экземпляра класса Bun с параметрами.
        bun = new Bun(nameBun, priceBun);
    }

    /**
     * Аннотация @Parameterized.Parameters используется для передачи набора данных для тестов.
     * Здесь мы определяем несколько различных комбинаций имени булки и её цены, чтобы проверить
     * корректное поведение конструктора Bun в различных сценариях.
     *
     * @return массив с параметрами для тестов.
     */
    @Parameterized.Parameters(name = "nameBun: {0}; priceBun: {1}") // Аннотация @Parameters задает параметры для теста.
    public static Object[][] getBun() {
        // Массив данных для параметризации:
        // {имя булки, цена булки}
        return new Object[][]{
                {"Меркурианская", 50.0f}, // Обычная булка с валидными значениями.
                {"Space", 0}, // Булка с нулевой ценой.
                {null, 50}, // Булка с null в качестве имени.
                {"777", 0}, // Булка с числовым названием и нулевой ценой.
                {"", 0.25f }, // Пустое имя булки и небольшая цена.
                {"@#$%", -100.5f} // Некорректное имя булки и отрицательная цена.
        };
    }

    /**
     * Тест метода getName() класса Bun.
     * Проверяем, что имя булки, переданное в конструктор, возвращается корректно.
     */
    @Test
    public void getNameExpectedEqualsActual() {
        // Проверка: ожидаемое значение (bun.name) должно совпадать с результатом вызова bun.getName().
        assertEquals(bun.name, bun.getName());
    }

    /**
     * Тест метода getPrice() класса Bun.
     * Проверяем, что цена булки, переданная в конструктор, возвращается корректно.
     */
    @Test
    public void getPriceExpectedEqualsActual() {
        // Проверка: ожидаемая цена bun.price должна совпадать с результатом вызова bun.getPrice().
        // Последний аргумент — это допустимая разница (дельта) для сравнения значений с плавающей точкой.
        assertEquals("Error getPrice", bun.price, bun.getPrice(), 0);
    }
}
