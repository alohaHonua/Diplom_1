import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;
import praktikum.Ingredient;

@RunWith(Parameterized.class)
public class IngredientTest {
    private Ingredient ingredient;
    private final IngredientType ingredientType;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType ingredientType, String name, float price) {
        this.ingredientType = ingredientType;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][]{
                {IngredientType.SAUCE, "Tomato Sauce", 2.5f},
                {IngredientType.FILLING, "Beef Patty", 3.0f}
        };
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(ingredientType, name, price);
    }

    @Test
    public void testGetPrice() {
        Assert.assertEquals(price, ingredient.getPrice(), 0.0001);
    }

    @Test
    public void testGetName() {
        Assert.assertEquals(name, ingredient.getName());
    }

    @Test
    public void testGetType() {
        Assert.assertEquals(ingredientType, ingredient.getType());
    }
}
