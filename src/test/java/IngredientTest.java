//package praktikum;

import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTest {

    @Test
    public void testGetName() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "chili sauce", 300);
        assertEquals("chili sauce", ingredient.getName());
    }

    @Test
    public void testGetPrice() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "chili sauce", 300);
        assertEquals(300, ingredient.getPrice(), 0.0);
    }

    @Test
    public void testGetType() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "chili sauce", 300);
        assertEquals(IngredientType.SAUCE, ingredient.getType());
    }
}
