package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Parameterized.class)
public class IngredientParameterizedTest {

    private final String inputTypeName;
    private final boolean isValid;

    public IngredientParameterizedTest(String inputTypeName, boolean isValid) {
        this.inputTypeName = inputTypeName;
        this.isValid = isValid;
    }

    @Parameterized.Parameters(name = "Type: {0}, Is Valid: {1}")
    public static Object[][] typeData() {
        return new Object[][]{
                {IngredientType.SAUCE.name(), true},
                {IngredientType.FILLING.name(), true},
                {"INVALID_TYPE", false},
                {"", false}
        };
    }

    @Test
    public void shouldCreateIngredientWithValidOrInvalidType() {
        String ingredientName = "Test ingredient";
        float ingredientPrice = 3.50f;

        if (isValid) {
            Ingredient ingredient = new Ingredient(IngredientType.valueOf(inputTypeName), ingredientName, ingredientPrice);
            assertEquals("Ingredient type does not match", inputTypeName, ingredient.getType().name());
            assertEquals("Ingredient name does not match", ingredientName, ingredient.getName());
            assertEquals("Ingredient price does not match", ingredientPrice, ingredient.getPrice(), 0.01);
        } else {
            IllegalArgumentException thrown = assertThrows(
                    IllegalArgumentException.class,
                    () -> new Ingredient(IngredientType.valueOf(inputTypeName), ingredientName, ingredientPrice)
            );
            assertThat("Error expected for invalid type", thrown.getMessage(), containsString("No enum constant praktikum.IngredientType"));
        }
    }
}
