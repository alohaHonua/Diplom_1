import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {
    private static final String TEST_INGREDIENT_NAME = "sampleIngredient";
    private static final float TEST_INGREDIENT_PRICE = 1.5F;
    private static final IngredientType TEST_INGREDIENT_TYPE = IngredientType.FILLING;

    @Test
    public void shouldReturnCorrectType() {
        Ingredient ingredient = new Ingredient(TEST_INGREDIENT_TYPE, TEST_INGREDIENT_NAME, TEST_INGREDIENT_PRICE);
        Assertions.assertEquals(TEST_INGREDIENT_TYPE, ingredient.getType());
    }

    @Test
    public void shouldReturnCorrectName() {
        Ingredient ingredient = new Ingredient(TEST_INGREDIENT_TYPE, TEST_INGREDIENT_NAME, TEST_INGREDIENT_PRICE);
        Assertions.assertEquals(TEST_INGREDIENT_NAME, ingredient.getName());
    }

    @Test
    public void shouldReturnCorrectPrice() {
        Ingredient ingredient = new Ingredient(TEST_INGREDIENT_TYPE, TEST_INGREDIENT_NAME, TEST_INGREDIENT_PRICE);
        Assertions.assertEquals(TEST_INGREDIENT_PRICE, ingredient.getPrice());
    }
}