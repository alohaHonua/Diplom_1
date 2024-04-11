package praktikum;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

public class IngredientTest {
    private Ingredient ingredient;

    Random random = new Random();
    private final float expectedPrice = random.nextFloat() * 100;
    private final String expectedName = RandomStringUtils.randomAlphabetic(10);

    @Before
    public void ingredientCreator() {
        ingredient = new Ingredient(null, expectedName, expectedPrice);
    }

    @Test
    public void checkGetIngredientName() {
        Assert.assertEquals(expectedName, ingredient.getName());
    }

    @Test
    public void checkGetIngredientPrice() {
        Assert.assertEquals(expectedPrice, ingredient.getPrice(), 1.0);
    }
}
