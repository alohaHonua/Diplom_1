package praktikum.ingredient;

import org.junit.Test;
import praktikum.Ingredient;
import praktikum.TestConstants;

import static org.junit.Assert.assertThrows;

public class IngredientNegativeTest {

    // Создание ингредиента с отрицательной ценой должно выбросить IllegalArgumentException
    @Test
    public void testCreateIngredientWithNegativePrice() {
        assertThrows(IllegalArgumentException.class, () ->
                new Ingredient(TestConstants.INGREDIENT2_TYPE, TestConstants.INGREDIENT2_NAME, TestConstants.INVALID_PRICE)
        );
    }

    // Создание ингредиента с пустым именем должно выбросить IllegalArgumentException
    @Test
    public void testCreateIngredientWithEmptyName() {
        assertThrows(IllegalArgumentException.class, () ->
                new Ingredient(TestConstants.INGREDIENT1_TYPE, TestConstants.EMPTY_INGREDIENT_NAME, TestConstants.INGREDIENT1_PRICE)
        );
    }
}
