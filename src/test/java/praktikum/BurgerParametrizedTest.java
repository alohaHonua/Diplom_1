package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)

public class BurgerParametrizedTest {
    private final Bun bun;
    private final List<Ingredient> ingredients;
    private final float expectedPrice;

    public BurgerParametrizedTest(Bun bun, List<Ingredient> ingredients, float expectedPrice) {
        this.bun = bun;
        this.ingredients = ingredients;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new Bun("white bun", 100), Arrays.asList(), 200},
                {new Bun("black bun", 150), Arrays.asList(new Ingredient(IngredientType.FILLING, "cheese", 50)), 350},
                {new Bun("red bun", 200), Arrays.asList(
                        new Ingredient(IngredientType.FILLING, "cutlet", 100),
                        new Ingredient(IngredientType.SAUCE, "mayo", 30),
                        new Ingredient(IngredientType.FILLING, "onion", 20)
                ), 550},
                {new Bun("premium bun", 500), Arrays.asList(
                        new Ingredient(IngredientType.SAUCE, "truffle", 300),
                        new Ingredient(IngredientType.FILLING, "wagyu", 1000)
                ), 2300}
        });
    }

    @Test
    public void testGetPrice() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        for (Ingredient ingredient : ingredients) {
            burger.addIngredient(ingredient);
        }

        assertEquals(expectedPrice, burger.getPrice(), 0.001);
    }
}
