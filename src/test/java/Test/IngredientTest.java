package Test;

import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;

public class IngredientTest {
    @Test
    public void testGetPrice() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Mayonnaise", 0.8f);
        assertEquals(0.8f, ingredient.getPrice(), 0.001);
    }

    @Test
    public void testGetName() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Bacon", 1.5f);
        assertEquals("Bacon", ingredient.getName());
    }

    @Test
    public void testGetType() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "BBQ Sauce", 1.2f);
        assertEquals(IngredientType.SAUCE, ingredient.getType());
    }
}