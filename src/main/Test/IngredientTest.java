import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class IngredientTest {
    public void testGetName() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Lettuce", 0.50f);
        assertEquals("Lettuce", ingredient.getName());
    }

    @Test
    public void testGetPrice() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Lettuce", 0.50f);
        assertEquals(0.50f, ingredient.getPrice(), 0.01);
    }

    @Test
    public void testGetType() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Ketchup", 0.20f);
        assertEquals(IngredientType.SAUCE, ingredient.getType());
    }
}
