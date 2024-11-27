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

    public IngredientParameterizedTest(String inputTypeName) {
        this.inputTypeName = inputTypeName;
    }

    @Parameterized.Parameters(name = "Ingredient Type Check: {0}")
    public static Object[][] typeData() {
        return new Object[][]{
                {IngredientType.SAUCE.name()},
                {IngredientType.FILLING.name()}
        };
    }

    @Test
    public void shouldCreateIngredientWithValidOrInvalidType() {
        String ingredientName = "Test ingredient";
        float ingredientPrice = 3.50f;

        if (isEnumValueValid(inputTypeName)) {
            Ingredient ingredient = new Ingredient(IngredientType.valueOf(inputTypeName), ingredientName, ingredientPrice);
            assertEquals("Ingredient type does not match", inputTypeName, ingredient.getType().name());
            assertEquals("Ingredient name does not match", ingredientName, ingredient.getName());
            assertEquals("Ingredient price does not match", ingredientPrice, ingredient.getPrice(), 0.01);
        } else {
            IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
                new Ingredient(IngredientType.valueOf(inputTypeName), ingredientName, ingredientPrice);
            });
            assertThat("Error expected for invalid type", thrown.getMessage(), containsString("No enum constant praktikum.IngredientType"));
        }
    }

    private boolean isEnumValueValid(String value) {
        for (IngredientType type : IngredientType.values()) {
            if (type.name().equals(value)) {
                return true;
            }
        }
        return false;
    }
}
