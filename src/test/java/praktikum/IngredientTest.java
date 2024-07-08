package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTest {

    @Test
    public void getPriceIngredientTest () {

        float expectedResult = 2F;

        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", expectedResult);

        float actualResult = ingredient.getPrice();

        assertEquals(expectedResult, actualResult, 0);

    }

    @Test
    public void getNameIngredientTest () {

        String expectedResult = "sausage";

        Ingredient ingredient = new Ingredient(IngredientType.FILLING, expectedResult, 2F);

        String actualResult = ingredient.getName();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getTypeIngredientTest () {

        IngredientType expectedResult = IngredientType.SAUCE;

        Ingredient ingredient = new Ingredient(expectedResult, "chili sauce", 2f);

        IngredientType actualResult = ingredient.getType();

        assertEquals(expectedResult, actualResult);
    }
}
