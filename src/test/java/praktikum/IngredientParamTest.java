package praktikum;


import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientParamTest {
    IngredientType type;
    String name;
    float price;

    @Parameterized.Parameters
    public static Object[][] data(){
           return new Object[][] {
                   {SAUCE, "hot sauce", 100},
                   {FILLING, "dinosaur", 200},
           };
    }

    public IngredientParamTest(IngredientType type, String name, float price){
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Test
    public void testGetPrice(){
        Ingredient ingredient = new Ingredient(type, name, price);
        float expected = price;
        float actual = ingredient.getPrice();
        assertEquals(expected, actual, 0);
    }
    @Test
    public void testGetName(){
        Ingredient ingredient = new Ingredient(type, name, price);
        String expected = name;
        String actual = ingredient.getName();
        assertEquals(expected, actual);
    }
    @Test
    public void testGetType(){
        Ingredient ingredient = new Ingredient(type, name, price);
        IngredientType expected = type;
        IngredientType actual = ingredient.getType();
        assertEquals(expected, actual);
    }
}
