package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Тесты для перечисления IngredientType.
 * Проверяется корректность значений перечисления.
 */
public class IngredientTypeTest {

    // Проверяет, что значение перечисления SAUCE возвращает правильную строку
    @Test
    public void testSauceTypeToString() {
        assertEquals("SAUCE", IngredientType.SAUCE.toString());
    }

    // Проверяет, что значение перечисления FILLING возвращает правильную строку
    @Test
    public void testFillingTypeToString() {
        assertEquals("FILLING", IngredientType.FILLING.toString());
    }
}
