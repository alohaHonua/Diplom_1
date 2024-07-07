import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Random;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestIngredient {
    private Ingredient ingredient;
    private final IngredientType ingredientType;
    private final String title;
    private final float cost;

    private final static RandomStringUtils randomStringUtils = new RandomStringUtils();
    private final static Random random = new Random();

    public TestIngredient(IngredientType ingredientType, String name, float price) {
        this.ingredientType = ingredientType;
        this.title = name;
        this.cost = price;
    }

    @Parameterized.Parameters
    public static Object[][] createIngredient() {
        return new Object[][]{
                {IngredientType.FILLING, randomStringUtils.randomAlphabetic(10), random.nextFloat()},
                {IngredientType.SAUCE, randomStringUtils.randomAlphabetic(10), random.nextFloat()}
        };
    }

    @Test
    public void TestGetPrice() {
        ingredient = new Ingredient(ingredientType, title, cost);

        assertEquals(cost, ingredient.getPrice(), 0);
    }
    @Test
    public void TestGetName() {
        ingredient = new Ingredient(ingredientType, title, cost);

        assertEquals(title, ingredient.getName());
    }

    @Test
    public void TestGetType() {
        ingredient = new Ingredient(ingredientType, title, cost);
        assertEquals(ingredientType, ingredient.getType());
    }
}
