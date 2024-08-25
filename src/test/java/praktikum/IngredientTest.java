package praktikum;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class IngredientTest extends TestCase {

    private IngredientType ingredientType;

    public IngredientTest(IngredientType ingredientType) {
        this.ingredientType = ingredientType;
    }

    @Parameterized.Parameters
    public static Collection provider() {
        return Arrays.asList(new Object[][] {
                { IngredientType.FILLING },
                { IngredientType.SAUCE }
        });
    }

    @Test
    public void shouldReturnExpectedNamePriceTypeWhenCreated() {
        String expectedName = "name";
        float expectedPrice = 3.14f;
        Ingredient ingredient = new Ingredient(ingredientType, expectedName, expectedPrice);

        String actualName = ingredient.getName();
        float actualPrice = ingredient.getPrice();
        IngredientType actualType = ingredient.getType();

        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedPrice, actualPrice, 0);
        Assert.assertEquals(ingredientType, actualType);
    }
}