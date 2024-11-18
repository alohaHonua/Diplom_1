import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {

    private Ingredient ingredient;

    @Parameterized.Parameter(0)
    public IngredientType type;

    @Parameterized.Parameter(1)
    public String name;

    @Parameterized.Parameter(2)
    public float price;

    @Parameterized.Parameter(3)
    public float expectedPrice;

    @Parameterized.Parameter(4)
    public String expectedName;

    @Parameterized.Parameter(5)
    public IngredientType expectedType;


    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {IngredientType.SAUCE, "hot sauce", 100f, 100f, "hot sauce", IngredientType.SAUCE},
                {IngredientType.FILLING, "cutlet", 100f, 100f, "cutlet", IngredientType.FILLING},
                {IngredientType.SAUCE, "sour cream", 200f, 200f, "sour cream", IngredientType.SAUCE},
                {IngredientType.FILLING, "sausage", 300f, 300f, "sausage", IngredientType.FILLING}
        });
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void testGetPrice() {
        assertEquals(expectedPrice, ingredient.getPrice(), 0.001);
    }

    @Test
    public void testGetName() {
        assertEquals(expectedName, ingredient.getName());
    }

    @Test
    public void testGetType() {
        assertEquals(expectedType, ingredient.getType());
    }
}