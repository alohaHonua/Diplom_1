import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import static org.junit.Assert.*;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(JUnitParamsRunner.class)
public class IngredientTest {
    private Ingredient ingredient;

    @Before
    public void setUp() {
        // This setup method can remain unchanged.
    }

    @Test
    public void testGetName() {
        ingredient = new Ingredient(IngredientType.SAUCE, "Mayo", 0.5f);
        assertEquals("Mayo", ingredient.getName());
    }

    @Test
    @Parameters({
            "SAUCE, Mayo, 0.5",
            "FILLING, Lettuce, 1.0",
            "FILLING, Tomato, 0.75"
    })
    public void testGetPrice(IngredientType type, String name, float price) {
        ingredient = new Ingredient(type, name, price);
        assertEquals(price, ingredient.getPrice(), 0.01);
    }

    @Test
    public void testGetType() {
        ingredient = new Ingredient(IngredientType.SAUCE, "Mayo", 0.5f);
        assertEquals(IngredientType.SAUCE, ingredient.getType());
    }
}
