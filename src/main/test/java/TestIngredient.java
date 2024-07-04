import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.hamcrest.CoreMatchers.is;
import static praktikum.parameters.Parameters.*;

@RunWith(Parameterized.class)
public class TestIngredient {
    private final Ingredient ingredient;

    public TestIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    @Parameterized.Parameters
    public static Object [][] ingredientTestData() {
        return new Object[][] {
                {new Ingredient(IngredientType.SAUCE, SAUCE_NAME, SAUCE_PRICE)},
                {new Ingredient(IngredientType.FILLING, FILLING_NAME, FILLING_PRICE)}
        };
    }

    @Test
    public void testGetPrice () {
        MatcherAssert.assertThat(ingredient.getPrice(), is(ingredient.price));
    }

    @Test
    public void testGetName() {
        MatcherAssert.assertThat(ingredient.getName(), is(ingredient.name));
    }

    @Test
    public void testGetType() {
        MatcherAssert.assertThat(ingredient.getType(), is(ingredient.type));
    }
}
