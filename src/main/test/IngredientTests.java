import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class IngredientTests {

    @Test
    public void testIngredientCreation() {
        IngredientType type = IngredientType.FILLING;
        String name = "hot sauce";
        float price = 1.5f;

        Ingredient ingredient = new Ingredient(type, name, price);

        assertNotNull(ingredient);
        assertEquals(type, ingredient.getType());
        assertEquals(name, ingredient.getName());
        assertEquals(price, ingredient.getPrice(), 0.0001f);
    }

    @Test
    public void testIngredientPrice() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "sour cream", 0.75f);

        assertEquals(0.75f, ingredient.getPrice(), 0.0001f);
    }

    @Test
    public void testIngredientName() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "cutlet", 0.5f);

        assertEquals("cutlet", ingredient.getName());
    }

    @Test
    public void testIngredientType() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "dinosaur", 1.0f);

        assertEquals(IngredientType.FILLING, ingredient.getType());
    }
}