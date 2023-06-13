import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class IngredientTests {

    private final IngredientType expectedType;
    private final String expectedName;
    private final float expectedPrice;

    public IngredientTests(IngredientType expectedType, String expectedName, float expectedPrice) {
        this.expectedType = expectedType;
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters(name = "Type: {0}, Name: {1}, Price: {2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {IngredientType.SAUCE, "Chili Sauce", 80.00f},
                {IngredientType.FILLING, "Beef Patty", 195.00f},
                {IngredientType.SAUCE, "Mayonnaise", 0f},
                {IngredientType.FILLING, "", 50f},
        });
    }

    @Test
    public void getPrice_shouldReturnCorrectPrice() {

        Ingredient ingredient = new Ingredient(expectedType, expectedName, expectedPrice);
        Assert.assertEquals(expectedPrice, ingredient.getPrice(), 0.001f);
    }

    @Test
    public void getName_shouldReturnCorrectName() {

        Ingredient ingredient = new Ingredient(expectedType, expectedName, expectedPrice);
        Assert.assertEquals(expectedName, ingredient.getName());
    }

    @Test
    public void getType_shouldReturnCorrectType() {

        Ingredient ingredient = new Ingredient(expectedType, expectedName, expectedPrice);
        Assert.assertEquals(expectedType, ingredient.getType());
    }
}