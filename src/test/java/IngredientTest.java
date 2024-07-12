import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {
    private IngredientType expectedType;
    private String expectedName;
    private float expectedPrice;

    public IngredientTest(IngredientType expectedType, String expectedName, float expectedPrice) {
        this.expectedType = expectedType;
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {IngredientType.SAUCE, "sichuan sauce", 13.6F},
                {IngredientType.FILLING, "black hole cheese", 22.6f},
                {IngredientType.SAUCE, "mars barbecue sauce", 18.8f},

        };
    }

    @Test
    public void getNameTest() {
        Ingredient testIngredient = new Ingredient(expectedType, expectedName, expectedPrice);

        String actualTestName = testIngredient.getName();
        String expectedTestName = expectedName;

        assertEquals(expectedTestName, actualTestName);
    }

    @Test
    public void getPriceTest() {
        Ingredient testIngredient = new Ingredient(expectedType, expectedName, expectedPrice);

        float actualTestPrice = testIngredient.getPrice();
        float expectedTestPrice = expectedPrice;

        assertEquals(expectedTestPrice, actualTestPrice, 0);
    }

    @Test
    public void getTypeTest() {
        Ingredient testIngredient = new Ingredient(expectedType, expectedName, expectedPrice);

        IngredientType actualTestType = testIngredient.getType();
        IngredientType expectedTestType = expectedType;

        assertEquals(expectedTestType, actualTestType);
    }
}
