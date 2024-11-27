import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {

    public Ingredient ingredient;

    @Parameterized.Parameter
    public IngredientType type;

    @Parameterized.Parameter(1)
    public String name;

    @Parameterized.Parameter(2)
    public float price;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {IngredientType.SAUCE, "hot sauce", 100},
                {IngredientType.SAUCE, "sour cream", 200},
                {IngredientType.SAUCE, "chili sauce", 300},
                {IngredientType.FILLING, "cutlet", 100},
                {IngredientType.FILLING, "dinosaur", 200},
                {IngredientType.FILLING, "sausage", 300},
        };
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void getTypeForIngredientTest() {
        assertEquals(type, ingredient.getType());
    }

    @Test
    public void getNameForIngredientTest() {
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void getPriceForIngredientTest() {
        assertEquals(price, ingredient.getPrice(), 0.001);
    }
}
