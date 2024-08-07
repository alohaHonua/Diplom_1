import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.*;

@RunWith(Parameterized.class)
public class IngredientTest {
    Ingredient ingredient;

    private final IngredientType expectedType;
    private final String expectedName;
    private final float expectedPrice;

    public IngredientTest(IngredientType expectedType, String expectedName, float expectedPrice) {
        this.expectedType = expectedType;
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Object[][] dataForTest() {
        return new Object[][]{
                {SAUCE, "Кетчуп", 49},
                {FILLING, "Сыр", 23},
        };
    }


    @Test
    public void getNameTest() {

        ingredient = new Ingredient(expectedType, expectedName, expectedPrice);
        assertEquals(expectedName, ingredient.getName());
    }

    @Test
    public void getPriceTest() {

        ingredient = new Ingredient(expectedType, expectedName, expectedPrice);
        assertEquals(expectedPrice, ingredient.getPrice(), 0.0f);
    }

    @Test
    public void getTypeTest() {

        ingredient = new Ingredient(expectedType, expectedName, expectedPrice);
        assertEquals(expectedType, ingredient.getType());
    }
}
