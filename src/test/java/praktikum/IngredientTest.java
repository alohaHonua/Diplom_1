package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class IngredientTest {

    @Test
    public void getIngredientPriceTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        Assert.assertEquals(ingredient.price, ingredient.getPrice(), 0);
    }

    @Test
    public void getIngredientNameTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        Assert.assertEquals("Unexpected name", ingredient.name, ingredient.getName());
    }

    @Test
    public void getIngredientTypeTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        Assert.assertEquals(ingredient.type, ingredient.getType());
    }
}
