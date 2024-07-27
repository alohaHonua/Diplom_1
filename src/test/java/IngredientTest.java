import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {

    @Test
    public void testGetPrice() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Ketchup", 0.5f);
        Assert.assertEquals(0.5f, ingredient.getPrice(), 0.0f);
    }

    @Test
    public void testGetName() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Lettuce", 0.3f);
        Assert.assertEquals("Lettuce", ingredient.getName());
    }

    @Test
    public void testGetType() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Mustard", 0.4f);
        Assert.assertEquals(IngredientType.SAUCE, ingredient.getType());
    }

    @Test
    public void testSetPrice() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Tomato", 0.7f);
        ingredient.price = 0.8f;
        Assert.assertEquals(0.8f, ingredient.getPrice(), 0.0f);
    }

    @Test
    public void testSetName() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Mayonnaise", 0.6f);
        ingredient.name = "Spicy Mayonnaise";
        Assert.assertEquals("Spicy Mayonnaise", ingredient.getName());
    }

    @Test
    public void testSetType() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Onion", 0.2f);
        ingredient.type = IngredientType.SAUCE;
        Assert.assertEquals(IngredientType.SAUCE, ingredient.getType());
    }
}
