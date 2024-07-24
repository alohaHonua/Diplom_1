package praktikum;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientParamTest extends ConstantData {
    IngredientType type;
    Ingredient ingredient;
    String name;
    float price;

    @Parameterized.Parameters
    public static Object[][] data(){
           return new Object[][] {
                   {INGREDIENT_TYPES[1], INGREDIENT_NAMES[1], INGREDIENT_PRICES[1]},
                   {INGREDIENT_TYPES[0], INGREDIENT_NAMES[0], INGREDIENT_PRICES[0]},
           };
    }

    public IngredientParamTest(IngredientType type, String name, float price){
        this.type = type;
        this.name = name;
        this.price = price;
    }
    @Before
    public void setUp(){
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void testGetPrice(){
        float expected = price;
        float actual = ingredient.getPrice();
        assertEquals(expected, actual, 0.1);
    }
    @Test
    public void testGetName(){
        String expected = name;
        String actual = ingredient.getName();
        assertEquals(expected, actual);
    }
    @Test
    public void testGetType(){
        IngredientType expected = type;
        IngredientType actual = ingredient.getType();
        assertEquals(expected, actual);
    }
}
