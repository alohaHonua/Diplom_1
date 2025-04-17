package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType type;
    private final String name;
    private final float price;
    private final Ingredient ingredient;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
        this.ingredient = new Ingredient(type, name, price);
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
            {IngredientType.SAUCE, "hot sauce", 100},
            {IngredientType.FILLING, "cutlet", 200}
        };
    }

    @Test
    public void testGetType() {
        assertEquals(type, ingredient.getType());
    }

    @Test
    public void testGetName() {
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void testGetPrice() {
        assertEquals(price, ingredient.getPrice(), 0.0f);
    }
} 