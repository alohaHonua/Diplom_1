import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Arrays;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class IngredientTest {

    private float price;
    private String name;
    Ingredient realIngredient;
    IngredientType type;
    @Before
    public void setUp(){
        type = FILLING;
        price = 2;
        name = "Cheese";
        realIngredient = new Ingredient(type, name, price);
    }

    @Test
    public void getPriceIngredient(){
        Assert.assertEquals(price,realIngredient.getPrice(),0.0);
    }

    @Test
    public void getNameIngredient(){
        Assert.assertEquals(name,realIngredient.getName());
    }

    @Test
    public void getTypeIngredient(){
        Assert.assertEquals(type,realIngredient.getType());
    }

    @Test
    public void ingredientTypeContainsTypes(){
        String IngredientArray = Arrays.toString(IngredientType.values());
        Assert.assertTrue(IngredientArray.contains("SAUCE") & IngredientArray.contains("FILLING"));
    }
}
