import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private final IngredientType ingredientType;

    public IngredientTypeTest(IngredientType ingredientType) {
       this.ingredientType = ingredientType;
   }
    @Parameterized.Parameters(name = "index {0}")
    public static Object[][] parameters() {
        return new Object[][]{
                {IngredientType.SAUCE},
                {IngredientType.FILLING},
        };
    }

    @Test
    public void testToString() {
        assertEquals("Отсутсвует ингредиент" , ingredientType.toString().toLowerCase(), ingredientType.name().toLowerCase());
    }

}
