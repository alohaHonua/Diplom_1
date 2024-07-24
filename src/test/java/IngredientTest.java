import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;

import static praktikum.IngredientType.SAUCE;

public class IngredientTest {


    private final String name = "Томатный соус";
    private final float price = 2F;

    @Test
    public void getPriceTest() {
        Ingredient ingredient = new Ingredient(SAUCE, name, price);
        Assert.assertEquals(price, ingredient.getPrice(), 0);
    }

    @Test
    public void getNameTest() {
        Ingredient ingredient = new Ingredient(SAUCE, name, price);
        Assert.assertEquals(name, ingredient.getName());
    }

    @Test
    public void getTypeTest() {
        Ingredient ingredient = new Ingredient(SAUCE, name, price);
        Assert.assertEquals(SAUCE, ingredient.getType());
    }

}
