package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;

public class IngredientTest {
    private Ingredient ingredient;
    private IngredientType type = SAUCE;
    private String name = "Name";
    private float price = 555.05f;

    @Before
    public void setUp(){
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void getType() {
        assertEquals(type, ingredient.getType());
    }

    @Test
    public void getName() {
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void getPrice() {
        assertEquals(price, ingredient.getPrice(), 0.001);
    }

}
