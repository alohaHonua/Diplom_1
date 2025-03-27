package Task1;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import praktikum.Database;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    private final Ingredient ingredient;
    private final String expectedName;
    private final IngredientType expectedType;
    private final float expectedPrice;

    @Parameterized.Parameters
    public static Object[] data() {
        Database database = new Database();
        return database.availableIngredients().stream()
                .map(ingredient -> new Object[]{ingredient.getName(), ingredient.getType(), ingredient.getPrice()})
                .toArray(Object[][]::new);
    }

    public IngredientTest(String expectedName, IngredientType expectedType, float expectedPrice) {
        this.ingredient = new Ingredient(expectedType, expectedName, expectedPrice);
        this.expectedName = expectedName;
        this.expectedType = expectedType;
        this.expectedPrice = expectedPrice;
    }

    @Test
    public void getPriceTest() {
        assertEquals(expectedPrice, ingredient.getPrice(), 0.0f);
    }

    @Test
    public void getNameTest() {
        assertEquals(expectedName, ingredient.getName());
    }

    @Test
    public void getTypeTest() {
        assertEquals(expectedType, ingredient.getType());
    }
}