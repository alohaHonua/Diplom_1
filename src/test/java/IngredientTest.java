import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {
    public static final String BEEF_METEORITE_CHOPPED = "Говяжий метеорит (отбивная)";
    public static final String SAUCE_SPICY_X = "Соус Spicy-X";
    public static final float PRICE_50 = 50.0f;
    public static final String SPACE_SAUCE = "Соус фирменный Space Sauce";
    public static final float PRICE_30 = 30.0f;
    public static final String FILLET_OF_TETRAODONIMFORM = "Филе Люминесцентного тетраодонтимформа";
    public static final float PRICE_120 = 120.0f;
    public static final float PRICE_80 = 80.0f;

    private final IngredientType expectedType;
    private final String expectedName;
    private final float expectedPrice;
    private final Ingredient ingredient;

    public IngredientTest(IngredientType type, String name, float price) {
        this.expectedType = type;
        this.expectedName = name;
        this.expectedPrice = price;
        this.ingredient = new Ingredient(type, name, price);
    }

    @Parameterized.Parameters
    public static Object[][] paramIngredientTest() {
        return new Object[][]{
                {IngredientType.SAUCE, SAUCE_SPICY_X, PRICE_50},
                {IngredientType.FILLING, BEEF_METEORITE_CHOPPED, PRICE_80},
                {IngredientType.FILLING, FILLET_OF_TETRAODONIMFORM, PRICE_120},
                {IngredientType.SAUCE, SPACE_SAUCE, PRICE_30}
        };
    }

    @Test
    public void getTypeReturnedSuccess() {
        assertEquals(expectedType, ingredient.getType());
    }

    @Test
    public void getNameReturnedSuccess() {
        assertEquals(expectedName, ingredient.getName());
    }

    @Test
    public void getPriceReturnedSuccess() {
        assertEquals(expectedPrice, ingredient.getPrice(), 0.0001f);
    }
}
