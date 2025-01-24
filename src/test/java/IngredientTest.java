import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTest {

    private final Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);

    @Test
    public void getPriceTest() {
        assertEquals(100, ingredient.getPrice(), 0.01);
    }

    @Test
    public void getNameTest() {
        assertEquals("hot sauce", ingredient.getName());
    }

    @Test
    public void getTypeTest() {
        assertEquals(IngredientType.SAUCE, ingredient.getType());
    }
}
