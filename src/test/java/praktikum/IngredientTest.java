package praktikum;

import org.junit.Test;
import static org.junit.Assert.*;
import praktikum.*;

public class IngredientTest {

    @Test
    public void testGetName() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Ketchup", 10.5f);
        assertEquals("Ketchup", ingredient.getName());
    }

    @Test
    public void testGetType() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Beef", 50.0f);
        assertEquals(IngredientType.FILLING, ingredient.getType());
    }

    @Test
    public void testGetPrice() {
        float price = 75.0f;
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Mustard", price);
        assertEquals(price, ingredient.getPrice(), 0.0f);
    }
}