import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTypeParameterizedTest {
    private final IngredientType ingredientType;

    public IngredientTypeParameterizedTest(IngredientType ingredientType) {
        this.ingredientType = ingredientType;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][]{
                {SAUCE},
                {FILLING},
        };
    }

    @Test
    public void valueOfIngredientTypeTest() {
        assertEquals(ingredientType, IngredientType.valueOf(ingredientType.toString()));
    }

}
