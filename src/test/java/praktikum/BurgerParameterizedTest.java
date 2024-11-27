package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BurgerParameterizedTest {
    private final float price;
    private final Bun bun;
    private final Ingredient ingredient;

    public BurgerParameterizedTest(float price, Bun bun, Ingredient ingredient) {
        this.price = price;
        this.bun = bun;
        this.ingredient = ingredient;
    }

    @Parameterized.Parameters(name = "Expected price: {0}, Bun: {1}, Ingredient: {2}")
    public static Object[][] data() {
        return new Object[][]{
                {10.0f, new Bun("Simple Bun", 2.5f), new Ingredient(IngredientType.SAUCE, "Ketchup", 2.5f)},
                {15.0f, new Bun("Deluxe Bun", 5.0f), new Ingredient(IngredientType.FILLING, "Cheese", 5.0f)}
        };
    }

    @Test
    public void getPrice() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        float actualPrice = burger.getPrice();
        assertEquals("Calculated price should match the expected price", price, actualPrice, 0.01f);
    }
}
