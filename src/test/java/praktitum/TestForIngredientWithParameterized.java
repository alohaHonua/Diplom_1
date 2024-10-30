package praktitum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestForIngredientWithParameterized {

    private IngredientType ingredientType;
    private String ingredientName;
    private float ingredientPrice;
    private Ingredient ingredient;

    public TestForIngredientWithParameterized(IngredientType ingredientType, String ingredientName, float ingredientPrice) {
        this.ingredientType = ingredientType;
        this.ingredientName = ingredientName;
        this.ingredientPrice = ingredientPrice;
        this.ingredient = new Ingredient(ingredientType, ingredientName,ingredientPrice);
    }

    @Parameterized.Parameters
    public static Object [][] ingridientParameters() {
        return new Object[][] {
                {IngredientType.SAUCE, "hot sauce", 100},
                {IngredientType.FILLING, "dinosaur", 200},
                {IngredientType.SAUCE, "chili sauce", 300}
        };
    }

    @Test
    public void testGetPrice() {
        assertEquals(ingredientPrice, ingredient.getPrice(), 0);
    }

    @Test
    public void testGetName() {
        assertEquals(ingredientName, ingredient.getName());
    }

    @Test
    public void testGetType() {
        assertEquals(ingredientType, ingredient.getType());
    }
}
