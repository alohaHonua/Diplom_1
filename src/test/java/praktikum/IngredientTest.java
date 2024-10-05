package praktikum;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parameters.Constants;
import static org.hamcrest.CoreMatchers.is;


@RunWith(Parameterized.class)
public class IngredientTest {
    private final Ingredient ingredient;
    public IngredientTest(Ingredient ingredient) {
        this.ingredient = ingredient;
    }
    @Parameterized.Parameters
    public static Object [][] ingredientTestData() {
        return new Object[][] {
                {new Ingredient(IngredientType.SAUCE, Constants.INGREDIENT_1_NAME, Constants.INGREDIENT_1_PRICE)},
                {new Ingredient(IngredientType.FILLING, Constants.INGREDIENT_2_NAME, Constants.INGREDIENT_2_PRICE)}
        };
    }

    @Test
    public void getPriceTest() {
        MatcherAssert.assertThat(ingredient.getPrice(),is(ingredient.price));
    }

    @Test
    public void getNameTest() {
        MatcherAssert.assertThat(ingredient.getName(),is(ingredient.name));
    }

    @Test
    public void getTypeTest() {
        MatcherAssert.assertThat(ingredient.getType(),is(ingredient.type));
    }
}