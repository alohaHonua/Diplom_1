package praktikum;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IngredientTest {

    @Test
    public void testIngredientProperties() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Hot Sauce", 99.9f);
        assertEquals(IngredientType.SAUCE, ingredient.getType());
        assertEquals("Hot Sauce", ingredient.getName());
        assertEquals(99.9f, ingredient.getPrice());
    }
}
