package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static tests.base.ConstantsForTests.INGREDIENT_MUSTARD;
import static tests.base.ConstantsForTests.INGREDIENT_PRICE;

public class IngredientTest {

    private Ingredient ingredient;

    @Before
    public void setUp() {
        ingredient = new Ingredient(IngredientType.SAUCE, INGREDIENT_MUSTARD, INGREDIENT_PRICE);
    }

    @Test
    public void getPriceTest() {
        Assert.assertEquals(INGREDIENT_PRICE, ingredient.getPrice(), 0);
    }

    @Test
    public void getNameTest() {
        Assert.assertEquals(INGREDIENT_MUSTARD, ingredient.getName());
    }

    @Test
    public void getTypeTest() {
        Assert.assertEquals(IngredientType.SAUCE, ingredient.getType());
    }
}