package praktikum;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Random;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientParamTest {
    private final IngredientType ingredientType;
    private Ingredient ingredient;

    Random random = new Random();
    private final float expectedPrice = random.nextFloat() * 100;
    private final String expectedName = RandomStringUtils.randomAlphabetic(10);
    public IngredientParamTest(IngredientType ingredientType)  {
        this.ingredientType = ingredientType;
    }

    @Parameterized.Parameters
    public static Object[] getParams() {
        return new Object[][]{
                {SAUCE},
                {FILLING}
        };
    }

    @Before
    public void ingredientCreator() {
        ingredient = new Ingredient(this.ingredientType, expectedName, expectedPrice);
    }

    @Test
    public void checkGetIngredientType() {
        Assert.assertEquals("Тип ингредиента не совпал",
                this.ingredientType,
                ingredient.getType());
    }
}