package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType expectedType;
    private final String expectedName;
    private final float expectedPrice;

    public IngredientTest(IngredientType expectedType, String expectedName, float expectedPrice) {
        this.expectedType = expectedType;
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters(name = "{index}: type={0}, name={1}, price={2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                { IngredientType.SAUCE, "Кетчуп", 0.5f },
                { IngredientType.FILLING, "Мясо", 0.0f }
        });
    }

    @Test
    public void getTypeReturnSameTypeTest() {
        Ingredient ingredient = new Ingredient(expectedType, expectedName, expectedPrice);
        assertEquals(expectedType, ingredient.getType());
    }

    @Test
    public void getNameReturnSameNameTest() {
        Ingredient ingredient = new Ingredient(expectedType, expectedName, expectedPrice);
        assertEquals(expectedName, ingredient.getName());
    }

    @Test
    public void getPriceReturnSamePriceTest() {
        Ingredient ingredient = new Ingredient(expectedType, expectedName, expectedPrice);
        assertEquals(expectedPrice, ingredient.getPrice(), 0.001f);
    }
}