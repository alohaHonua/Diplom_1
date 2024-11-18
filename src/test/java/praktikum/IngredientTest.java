package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType ingredientType;
    private final String name;
    private final float price;

    private Ingredient ingredient;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][] {
                {IngredientType.SAUCE, "Соус Spicy-X", 90},
                {IngredientType.FILLING, "Плоды Фалленианского дерева", 874},
        };
    }

    public IngredientTest(IngredientType ingredientType, String name, float price) {
        this.ingredientType = ingredientType;
        this.name = name;
        this.price = price;
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(ingredientType, name, price);
    }

    @Test
    public void getPriceTest(){
        float expected = price;
        float actual= ingredient.getPrice();
        Assert.assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void getNameTest(){
        String expected = name;
        String actual= ingredient.getName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getTypeTest(){
        IngredientType expected = ingredientType;
        IngredientType actual= ingredient.getType();
        Assert.assertEquals(expected, actual);
    }
}