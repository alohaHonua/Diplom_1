package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BurgerParameterizedTest {

    private Bun bun;
    private Ingredient ingredient;
    private float expectedPrice;

    public BurgerParameterizedTest(Bun bun, Ingredient ingredient, float expectedPrice) {
        this.bun = bun;
        this.ingredient = ingredient;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        Database database = new Database();
        List<Bun> buns = database.availableBuns();
        List<Ingredient> ingredients = database.availableIngredients();

        return new Object[][] {
                { buns.get(0), ingredients.get(3), buns.get(0).getPrice() * 2 + ingredients.get(3).getPrice() },
                { buns.get(1), ingredients.get(1), buns.get(1).getPrice() * 2 + ingredients.get(1).getPrice() },
                { buns.get(2), ingredients.get(2), buns.get(2).getPrice() * 2 + ingredients.get(2).getPrice() },
                { buns.get(0), ingredients.get(4), buns.get(0).getPrice() * 2 + ingredients.get(4).getPrice() },
                { buns.get(1), ingredients.get(5), buns.get(1).getPrice() * 2 + ingredients.get(5).getPrice() }
        };
    }

    @Test
    public void testBurgerPrice() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        assertEquals(expectedPrice, burger.getPrice(), 0.01);
    }
}
