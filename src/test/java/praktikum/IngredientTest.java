package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Тесты модели Ingredient — проверяется корректность геттеров.
 */
public class IngredientTest {

    // Проверяет, что getPrice() возвращает правильную цену
    @Test
    public void testGetPrice() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Spicy", 20.5f);
        assertEquals(20.5f, ingredient.getPrice(), 0.01);
    }

    // Проверяет, что getName() возвращает корректное имя ингредиента
    @Test
    public void testGetName() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Cheese", 10.0f);
        assertEquals("Cheese", ingredient.getName());
    }

    // Проверяет, что getType() возвращает нужный тип ингредиента
    @Test
    public void testGetType() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Ketchup", 5.0f);
        assertEquals(IngredientType.SAUCE, ingredient.getType());
    }
}
