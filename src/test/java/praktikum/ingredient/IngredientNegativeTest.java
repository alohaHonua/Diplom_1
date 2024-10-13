package praktikum.ingredient;

import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientNegativeTest {

    // Тест: создание ингредиента с отрицательной ценой должно выбрасывать исключение
    @Test(expected = IllegalArgumentException.class)
    public void testCreateIngredientWithNegativePrice() {
        new Ingredient(IngredientType.FILLING, "Invalid Ingredient", -10);
    }

    // Тест: создание ингредиента с пустым именем должно выбрасывать исключение
    @Test(expected = IllegalArgumentException.class)
    public void testCreateIngredientWithEmptyName() {
        new Ingredient(IngredientType.SAUCE, "", 50);
    }
}
