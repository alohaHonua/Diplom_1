import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import praktikum.Database;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.List;

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
