import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTests {
    private String name = "ingredient_name";
    private float price = 5.0F;
    IngredientType type;
    Ingredient ingredient;
    @Before
    public void setUp(){
        ingredient = new Ingredient(type,name,price);
    }
    @Test
    public void getPriceTest(){
        assertEquals(price,ingredient.getPrice(),0);
    }
    @Test
    public void getNameTest(){
        assertEquals(name,ingredient.getName());
    }
}
