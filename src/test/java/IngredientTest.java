import org.junit.Test;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;


public class IngredientTest {


    final String name = "hot sauce";
    final float price = 100;

    @Test
    public void getPriceTest() {
        Ingredient ingredient = new Ingredient(SAUCE, "hot sauce", 100);
        assertEquals(price, ingredient.getPrice(), 0.0);
    }

    @Test
    public void getNameTest() {
        Ingredient ingredient = new Ingredient(SAUCE, "hot sauce", 100);
        assertEquals(name, ingredient.getName());
    }

}
