package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private Ingredient ingredient;
    private final String bunName;
    private final float bunPrice;
    private final IngredientType ingredientType;

    public IngredientTypeTest(IngredientType ingredientType, String bunName, float bunPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
        this.ingredientType = ingredientType;
    }

    @Parameterized.Parameters(name = "ingredientType: {0}, bunName: {1}, bunPrice: {2}")
    public static Object[][] getIngredientData() {
        return new Object[][]{
                {IngredientType.FILLING, "Флюоресцентная", 988.0f},
                {IngredientType.SAUCE, "Kratornaya", 1255},
                {IngredientType.FILLING, null, 0},
                {IngredientType.SAUCE, "", 0.5f }
        };
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(ingredientType, bunName, bunPrice);
    }

    @Test
    public void getIngredientPriceTest() {
        float actualResult = ingredient.getPrice();
        assertEquals(bunPrice, actualResult, 0);
    }

    @Test
    public void getIngredientNameTest() {
        String actualResult = ingredient.getName();
        assertEquals(bunName, actualResult);
    }

    @Test
    public void getIngredientTypeTest() {
        IngredientType actualResult = ingredient.getType();
        assertEquals(ingredientType, actualResult);
    }

    @Test
    public void sauceValue() {
        IngredientType actual = IngredientType.SAUCE;
        IngredientType excepted = IngredientType.valueOf("SAUCE");
        assertEquals("sauceValue Error",excepted,actual);
    }

    @Test
    public void fillingValue() {
        IngredientType actual = IngredientType.FILLING;
        IngredientType excepted = IngredientType.valueOf("FILLING");
        assertEquals("fillingValue Error",excepted,actual);
    }
}