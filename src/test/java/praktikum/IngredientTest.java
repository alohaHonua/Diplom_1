package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static praktikum.IngredientType.SAUCE;

public class IngredientTest {
    private static final String name = "hot sauce";
    private static final float price = 100;
    private Ingredient ingredient;

    @Before
    public void createNewIngredient(){
       ingredient = new Ingredient(SAUCE, name, price);
    }

    @Test
    public void checkGetType(){
        assertEquals(SAUCE, ingredient.getType());
    }

    @Test
    public void checkGetName(){
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void checkGetPrice(){
        assertEquals(price, ingredient.getPrice(), 0);
    }
}
