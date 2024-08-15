import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTest {

    @Test
    public void testGetName() {
        // Тест на проверку корректного получения имени ингредиента
        String expectedName = "chili sauce";
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, expectedName, 300);
        assertEquals(expectedName, ingredient.getName());
    }

    @Test
    public void testGetPrice() {
        // Тест на проверку корректного получения цены ингредиента
        float expectedPrice = 300.0f;
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "chili sauce", expectedPrice);
        assertEquals(expectedPrice, ingredient.getPrice(), 0.0);
    }

    @Test
    public void testGetType() {
        // Тест на проверку корректного получения типа ингредиента
        IngredientType expectedType = IngredientType.SAUCE;
        Ingredient ingredient = new Ingredient(expectedType, "chili sauce", 300);
        assertEquals(expectedType, ingredient.getType());
    }
}
