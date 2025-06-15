package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class BurgerParamTest {

    private final String bunName;
    private final float bunPrice;
    private final String ingredientName;
    private final IngredientType ingredientType;
    private final float ingredientPrice;

    public BurgerParamTest(String bunName, float bunPrice, String ingredientName, IngredientType ingredientType, float ingredientPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
        this.ingredientName = ingredientName;
        this.ingredientType = ingredientType;
        this.ingredientPrice = ingredientPrice;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"Зеленая булочка", 1.4f, "Соус", SAUCE, 2.7f},
                {"Стандартная булочка", 1.8f, "Котлета", FILLING, 3.7f}
        };
    }

    @Test
    public void checkNameAndPriceOfReceipt() {

        Bun bun = mock(Bun.class);
        when(bun.getName()).thenReturn(bunName);
        when(bun.getPrice()).thenReturn(bunPrice);

        Ingredient ingredient = mock(Ingredient.class);
        when(ingredient.getName()).thenReturn(ingredientName);
        when(ingredient.getType()).thenReturn(ingredientType);
        when(ingredient.getPrice()).thenReturn(ingredientPrice);

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        float expectedPrice = 2 * bunPrice + ingredientPrice;
        String receipt = burger.getReceipt();

        assertTrue("ошибка в названии булки", receipt.contains(bunName));
        assertTrue("ошибка в названии ингридиента", receipt.contains(ingredientType.toString().toLowerCase() + " " + ingredientName));
        assertTrue("ошибка в стоимости", receipt.contains(String.format("%f", expectedPrice)));
    }
}

