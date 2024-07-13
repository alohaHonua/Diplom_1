package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;

public class IngredientTest {
    private Ingredient ingredient;

    @Before
    public void setUp(){
        ingredient = new Ingredient(SAUCE, "hot sauce", 100);
    }

    @Test
    public void getPriceTest(){
        float actualPrice = ingredient.getPrice();
        float expectedPrice = 100;

        assertEquals(expectedPrice, actualPrice, 0);
    }

    @Test
    public void getNameTest(){
        String actualName = ingredient.getName();
        String expectedName = "hot sauce";

        assertEquals(expectedName, actualName);
    }

    @Test
    public void getTypeTest(){
        IngredientType actualType = ingredient.getType();

        assertEquals(SAUCE, actualType);
    }
}
