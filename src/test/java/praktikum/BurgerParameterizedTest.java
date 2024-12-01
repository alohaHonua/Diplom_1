package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


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
        Bun bun1 = Mockito.mock(Bun.class);
        Ingredient ingredient1 = Mockito.mock(Ingredient.class);
        when(bun1.getPrice()).thenReturn(2.5f);
        when(bun1.getName()).thenReturn("Simple Bun");
        when(ingredient1.getPrice()).thenReturn(2.5f);
        when(ingredient1.getName()).thenReturn("Ketchup");
        when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);

        Bun bun2 = Mockito.mock(Bun.class);
        Ingredient ingredient2 = Mockito.mock(Ingredient.class);
        when(bun2.getPrice()).thenReturn(5.0f);
        when(bun2.getName()).thenReturn("Deluxe Bun");
        when(ingredient2.getPrice()).thenReturn(5.0f);
        when(ingredient2.getName()).thenReturn("Cheese");
        when(ingredient2.getType()).thenReturn(IngredientType.FILLING);

        return new Object[][]{
                {7.5f, bun1, ingredient1},
                {15.0f, bun2, ingredient2}
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
