import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class BurgersPriceTest {

    private final Bun bun;
    private final Ingredient[] ingredients;
    private final float expectedPrice;

    public BurgersPriceTest(Bun bun, Ingredient[] ingredients, float expectedPrice) {
        this.bun = bun;
        this.ingredients = ingredients;
        this.expectedPrice = expectedPrice;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { new Bun("black bun", 100),
                        new Ingredient[] { new Ingredient(IngredientType.FILLING, "beef", 150),
                                new Ingredient(IngredientType.SAUCE, "mustard", 20) },
                        370f },
                { new Bun("white bun", 200),
                        new Ingredient[] { new Ingredient(IngredientType.FILLING, "chicken", 120) },
                        520f },
        });
    }

    @Test
    public void testToGetPrice() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        for (Ingredient ingredient : ingredients) {
            burger.addIngredient(ingredient);
        }
        assertEquals(expectedPrice, burger.getPrice(), 0.001);
    }
}