package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertFalse;

/**
 * Тесты для класса Database.
 * В этих тестах проверяется, что методы класса Database возвращают непустые списки булок и ингредиентов.
 */
public class DatabaseTest {

    // Инициализация объекта класса Database, который будет тестироваться.
    private final Database db = new Database();

    /**
     * @Test указывает, что этот метод является тестом.
     * Этот тест проверяет, что метод availableBuns возвращает непустой список булок.
     */
    @Test
    public void availableBunsReturnedListOfBuns() {
        // Проверка: список булок не должен быть пустым.
        assertFalse(db.availableBuns().isEmpty());
    }

    /**
     * @Test указывает, что этот метод является тестом.
     * Этот тест проверяет, что метод availableIngredients возвращает непустой список ингредиентов.
     */
    @Test
    public void availableIngredientsReturnedListOfIngredients() {
        // Проверка: список ингредиентов не должен быть пустым.
        assertFalse(db.availableIngredients().isEmpty());
    }
}
