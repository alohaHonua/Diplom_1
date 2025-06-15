package praktikum;

import org.junit.Assert;
import org.junit.Test;

import static praktikum.IngredientType.SAUCE;

public class IngredientTest {

    private final String name = "бургер";
    private final float price = 4.1f;

    Ingredient ingredient = new Ingredient(SAUCE, name, price);

    @Test
    public void testGetPrice() {
        Assert.assertEquals(price, ingredient.getPrice(), 0.0001f);
    }

    @Test
    public void testGetName() {
        Assert.assertEquals(name, ingredient.getName());
    }

    @Test
    public void testGetType() {
        Assert.assertEquals(SAUCE, ingredient.getType());
    }
}