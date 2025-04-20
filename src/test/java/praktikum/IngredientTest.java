package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTest {

    @Test
    public void testGetName() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "cutlet", 100);
        assertEquals("cutlet", ingredient.getName());
    }

    @Test
    public void testGetPrice() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 150);
        assertEquals(150, ingredient.getPrice(), 0.01);
    }

    @Test
    public void testGetType() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "sausage", 200);
        assertEquals(IngredientType.FILLING, ingredient.getType());
    }
}
