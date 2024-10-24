package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Parameterized.class)
public class IngredientTypeParamTest {

    private final String ingredientTypeTest;

    public IngredientTypeParamTest(String ingredientTypeTest) {
        this.ingredientTypeTest = ingredientTypeTest;
    }

    @Parameterized.Parameters
    public static Object[][] IngredientTypes() {
        return new Object[][]{
                {"SAUCE"},
                {"FILLING"},
        };
    }

    @Test
    public void valueOfTest() {
        assertThat(IngredientType.valueOf(ingredientTypeTest), is(notNullValue()));
    }
}