package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class IngredientTest {

    private static final String ingredientNameTest = "Тестовая котлета";
    private static final float ingredientPriceTest = 10.00F;
    private static final IngredientType ingredientTypeTest = IngredientType.FILLING;

    @Test
    public void getPriceTest() {

        Ingredient ingredient = new Ingredient(ingredientTypeTest, ingredientNameTest, ingredientPriceTest);

        Assert.assertEquals(ingredientPriceTest, ingredient.getPrice(), 0.0F);
    }

    @Test
    public void getNameTest() {

        Ingredient ingredient = new Ingredient(ingredientTypeTest, ingredientNameTest, ingredientPriceTest);

        Assert.assertEquals(ingredientNameTest, ingredient.getName());
    }

    @Test
    public void getTypeTest() {

        Ingredient ingredient = new Ingredient(ingredientTypeTest, ingredientNameTest, ingredientPriceTest);

        Assert.assertEquals(ingredientTypeTest, ingredient.getType());
    }
}