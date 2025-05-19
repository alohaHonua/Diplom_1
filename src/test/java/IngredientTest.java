import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;

public class IngredientTest {
    private Ingredient ingredient;
    @Before
    public void createIngredient(){
        ingredient = new Ingredient(SAUCE, "Бургерный", 10.50f);
    }

    @Test
    public void ingredientGetTypeTest() {
        assertEquals(ingredient.getType(), SAUCE);
    }

    @Test
    public void ingredientGetNameTest() {
        assertEquals(ingredient.getName(), "Бургерный");
    }

    @Test
    public void ingredientGetPriceTest() {
        assertEquals(ingredient.getPrice(), 10.50f, 0);
    }

}
