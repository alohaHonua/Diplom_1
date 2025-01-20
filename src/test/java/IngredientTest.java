import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType ingredientType;
    private final String expectedName;
    private final float expectedPrice;

    public IngredientTest(IngredientType ingredientType, String expectedName, float expectedPrice) {
        this.ingredientType = ingredientType;
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {IngredientType.SAUCE, "hot sauce", 100f},
                {IngredientType.FILLING, "cutlet", 100f}
        };
    }

    @Test
    public void testIngredient() {
        Ingredient ingredient = new Ingredient(ingredientType, expectedName, expectedPrice);

        assertSoftly(softly -> {
            softly.assertThat(ingredient.getName()).isEqualTo(expectedName);
            softly.assertThat(ingredient.getPrice()).isEqualTo(expectedPrice);
            softly.assertThat(ingredient.getType()).isEqualTo(ingredientType);
        });
    }
}



