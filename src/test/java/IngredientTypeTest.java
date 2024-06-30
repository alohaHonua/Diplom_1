import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private final String type;

    public IngredientTypeTest(String type) {
        this.type = type;
    }

    @Parameterized.Parameters(name = "IngredientType: {0}")
    public static Object[][] data() {
        return new Object[][] {
                {"SAUCE"},
                {"FILLING"}
        };
    }

    @Test
    public void ingredientTypeTest() {
        IngredientType ingredientType = IngredientType.valueOf(type);
        assertThat(ingredientType, is(notNullValue()));
    }
}
