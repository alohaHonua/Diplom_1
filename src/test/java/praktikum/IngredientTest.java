package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {
    public IngredientTest(IngredientType ingredientType, IngredientType expType) {
        this.ingredientType = ingredientType;
        this.expType = expType;
    }

    private final IngredientType ingredientType;
    private final IngredientType expType;

    @Parameterized.Parameters
    public static Object[][] getIngredientsData() {
        return new Object[][]{
                {SAUCE, SAUCE},
                {FILLING, FILLING},
        };
    }

    @Test
    public void gettersReturnCorrectValue() {
        Ingredient ingredient = new Ingredient(ingredientType, "кетчунез", 5);
        assertEquals(expType, ingredient.getType());
        assertEquals("кетчунез", ingredient.getName());
        assertEquals(5, ingredient.getPrice(), 0);
    }
}
