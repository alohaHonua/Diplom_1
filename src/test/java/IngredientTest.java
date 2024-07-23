import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static praktikum.IngredientType.SAUCE;

public class IngredientTest {


    private String name = "Томатный соус";
    private float price = 2F;

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
