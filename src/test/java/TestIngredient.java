import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static org.junit.Assert.assertEquals;


public class TestIngredient {
    IngredientType sauce;
    String name;
    float price;
    @Test
    public void testGetPrice() {
        Ingredient ingredient = new Ingredient(sauce, name, price);
        assertEquals(ingredient.getPrice(), price, 0);

    }
    @Test
    public void testGetName() {
        Ingredient ingredient = new Ingredient(sauce, name, price);
        assertEquals(ingredient.getName(), name);
    }
    @Test
    public void testGetType() {
        Ingredient ingredient = new Ingredient(sauce, name, price);
        assertEquals(ingredient.getType(), sauce);
    }
}
