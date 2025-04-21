package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static praktikum.ConfigConst.MOZART;
import static praktikum.ConfigConst.PRICE;



public class IngredientTest {

    Ingredient ingredient;
    @Before
    public void setUp () {
        ingredient = new Ingredient(IngredientType.FILLING,MOZART,PRICE);}

    @Test
    public void getBunTest()  {
        assertEquals(35.0f,ingredient.getPrice(),1);
        assertEquals("mozart",ingredient.getName());
        assertEquals(IngredientType.FILLING,ingredient.getType());
    }
}
