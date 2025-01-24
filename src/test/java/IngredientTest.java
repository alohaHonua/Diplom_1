import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTest {

    private Ingredient ingredient;

    @Test
    public void getPriceTest() {
        ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        assertEquals(100, ingredient.getPrice(), 0.01);
    }

    @Test
    public void getNameTest() {
        ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        assertEquals("hot sauce", ingredient.getName());
    }

    @Test
    public void getTypeTest() {
        ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        assertEquals(IngredientType.SAUCE, ingredient.getType());
    }
}
