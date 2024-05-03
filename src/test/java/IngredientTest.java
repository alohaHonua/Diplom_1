import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static praktikum.IngredientType.FILLING;

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
}
