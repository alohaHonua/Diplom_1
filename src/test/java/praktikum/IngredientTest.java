package praktikum;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Random;

import static org.junit.Assert.*;
@RunWith(Parameterized.class)
public class IngredientTest {
    Ingredient ingredient;
    static Random random = new Random();
    String name;
    float price;
    IngredientType type;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }
    @Parameterized.Parameters
    public static Object[][] params() {
        return new Object[][]{
                {IngredientType.values()[random.nextInt(IngredientType.values().length)], RandomStringUtils.randomAlphabetic(20), 100F},
                {IngredientType.values()[random.nextInt(IngredientType.values().length)], RandomStringUtils.randomAlphabetic(20), 1000F},
                {IngredientType.values()[random.nextInt(IngredientType.values().length)], RandomStringUtils.randomAlphabetic(20), 1F},
                {IngredientType.values()[random.nextInt(IngredientType.values().length)], RandomStringUtils.randomAlphabetic(20), 0F},
                {IngredientType.values()[random.nextInt(IngredientType.values().length)], "", 100F},
                {null, RandomStringUtils.randomAlphabetic(20), 100F},
        };
    }
    @Before
    public void createIngredient(){
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void getPriceTest() {
        Assert.assertEquals(price, ingredient.getPrice(),0.01);
    }

    @Test
    public void getNameTest() {
        Assert.assertEquals(name, ingredient.getName());
    }

    @Test
    public void getTypeTest() {
        Assert.assertEquals(type, ingredient.getType());
    }
}