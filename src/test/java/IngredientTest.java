import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static org.junit.Assert.assertEquals;

public class IngredientTest {
    IngredientType type = IngredientType.SAUCE;
    Ingredient ingredient = new Ingredient(type, "Ketchup", 1.50f);
    @Test
    public void testGetName() {
        assertEquals("Ketchup", ingredient.getName());
    }

    @Test
    public void testGetPrice() {
        assertEquals(1.50f, ingredient.getPrice(), 0.01f);
    }

    @Test
    public void testGetType() {
        assertEquals(type, ingredient.getType());
    }
}

