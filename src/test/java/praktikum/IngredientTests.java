package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IngredientTests {
    private Ingredient ingredient;
    private final IngredientType ingredientType = IngredientType.FILLING;
    private final String name = "dinosaur";
    private final float price = 200f;

    @Before
    public void newIngredient() {
        ingredient = new Ingredient(ingredientType, name, price);
    }

    @Test
    public void getNameTest() {
        String result = ingredient.getName();
        Assert.assertEquals(name, result);
    }

    @Test
    public void getPriceTest() {
        float result = ingredient.getPrice();
        Assert.assertEquals(price, result, 0);
    }

    @Test
    public void getTypeTest() {
        IngredientType type = ingredient.getType();
        Assert.assertEquals(ingredientType, type);
    }
}
