import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class BurgerTest {

    private Burger burger;
    private Bun bun;
    private Ingredient[] ingredients;
    private float expectedPrice;

    public BurgerTest(Bun bun, Ingredient[] ingredients, float expectedPrice) {
        this.bun = bun;
        this.ingredients = ingredients;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {
                        new Bun("black bun", 100),
                        new Ingredient[]{new Ingredient(IngredientType.FILLING, "cutlet", 100)},
                        300 // (100 * 2) + 100
                },
                {
                        new Bun("white bun", 120),
                        new Ingredient[]{new Ingredient(IngredientType.FILLING, "cheese", 80), new Ingredient(IngredientType.FILLING, "sausage", 200)},
                        520 // (120 * 2) + 80 + 200
                }
        });
    }


    @Test
    public void testGetReceipt() {
        String expectedReceipt = String.format("(==== %s ====)%n", bun.getName());
        for (Ingredient ingredient : ingredients) {
            expectedReceipt += String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(), ingredient.getName());
        }
        expectedReceipt += String.format("(==== %s ====)%n", bun.getName());
        expectedReceipt += String.format("%nPrice: %f%n", burger.getPrice());

        Assert.assertEquals(expectedReceipt, burger.getReceipt());
    }

    @Before
    public void setUp() {
        burger = new Burger();
        burger.setBuns(bun);
        for (Ingredient ingredient : ingredients) {
            burger.addIngredient(ingredient);
        }
    }

    @Test
    public void testGetPrice() {
        Assert.assertEquals(expectedPrice, burger.getPrice(), 0.0f);
    }
}