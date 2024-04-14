package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;

public class IngredientTest {

    Ingredient ingredientForTest = new Ingredient(SAUCE,"Ингридиент", 100);

    @Test
    public void checkGetPrice(){
        assertEquals(100F,ingredientForTest.getPrice(), 0);
    }

    @Test
    public void checkGetName(){
        assertEquals("Ингридиент",ingredientForTest.getName());
    }

    @Test
    public void checkGetType(){
        assertEquals(SAUCE, ingredientForTest.getType());
    }
}
