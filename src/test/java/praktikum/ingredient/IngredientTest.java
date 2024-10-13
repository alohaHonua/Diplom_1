package praktikum.ingredient;

import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTest {

    // Тест: проверка получения имени ингредиента
    @Test
    public void testGetIngredientName() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Ketchup", 100);
        assertEquals("Ketchup", ingredient.getName());
    }

    // Тест: проверка получения типа ингредиента
    @Test
    public void testGetIngredientType() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Chicken", 150);
        assertEquals(IngredientType.FILLING, ingredient.getType());
    }

    // Тест: проверка получения цены ингредиента
    @Test
    public void testGetIngredientPrice() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Mayo", 50);
        assertEquals(50, ingredient.getPrice(), 0.01);
    }
}
