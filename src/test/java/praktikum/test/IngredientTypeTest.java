 package praktikum.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private final IngredientType ingredientType;

    public IngredientTypeTest(IngredientType ingredientType) {
        this.ingredientType = ingredientType;
    }

    @Parameterized.Parameters(name = "Ingredient Type: {0}")
    public static Object[][] testDateGen() {
        return new Object[][]{
                {SAUCE},
                {FILLING}
        };
    }

    @Test
    public void ingredientTypesTest() {
        assertThat(String.valueOf(ingredientType), is(notNullValue()));
    }
}