import praktikum.*;
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
    public IngredientTypeTest(IngredientType ingredientType, String bunName, float priceBun) {
        this.bunName = bunName;
        this.bunPrice = priceBun;
        this.ingredientType = ingredientType;
    }
    @Parameterized.Parameters()
    public static Object[][] getIngredientData() {
        return new Object[][]{
                {IngredientType.FILLING, "1-ая космическая", 43.55f},
                {IngredientType.SAUCE, "2-ая космическяа", 91.14f},
                {null, "123", 135},
                {IngredientType.SAUCE, "####", 15031.3999f},
                {IngredientType.FILLING, null, 0},
                {IngredientType.SAUCE, "", 0},
        };
    }
    @Before
    public void setUp() {
        ingredient = new Ingredient(ingredientType, bunName, bunPrice);
    }
    @Test
    public void getPriceIngredient() {
        float actualResult = ingredient.getPrice();
        assertEquals(bunPrice, actualResult, 0);
    }
    @Test
    public void getNameIngredient() {
        String actualResult = ingredient.getName();
        assertEquals(bunName, actualResult);
    }
    @Test
    public void getTypeIngredient() {
        IngredientType actualResult = ingredient.getType();
        assertEquals(ingredientType, actualResult);
    }
    @Test
    public void valuesSauce() {
        IngredientType actual = IngredientType.SAUCE;
        IngredientType excepted = IngredientType.valueOf("SAUCE");
        assertEquals("Ошибочное значение",excepted,actual);
    }
    @Test
    public void valueFilling() {
        IngredientType actual = IngredientType.FILLING;
        IngredientType excepted = IngredientType.valueOf("FILLING");
        assertEquals("Ошибочное значение",excepted,actual);
    }
}