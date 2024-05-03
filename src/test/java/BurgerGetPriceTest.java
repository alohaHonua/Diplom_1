import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class BurgerGetPriceTest {

    private Bun bun;
    private Ingredient[] ingredients;
    private float expectedPrice;

    public BurgerGetPriceTest(Bun bun, Ingredient[] ingredients, float expectedPrice) {
        this.bun = bun;
        this.ingredients = ingredients;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        // Создаем моки для Bun
        Bun bun1 = mock(Bun.class);
        when(bun1.getPrice()).thenReturn(2.50f);
        Bun bun2 = mock(Bun.class);
        when(bun2.getPrice()).thenReturn(3.00f);

        // Создаем моки для Ingredient
        Ingredient ingredient1 = mock(Ingredient.class);
        when(ingredient1.getPrice()).thenReturn(1.00f);
        Ingredient ingredient2 = mock(Ingredient.class);
        when(ingredient2.getPrice()).thenReturn(0.75f);

        return Arrays.asList(new Object[][]{
                {bun1, new Ingredient[]{ingredient1, ingredient1,ingredient2}, 7.75f},
                {bun1, new Ingredient[]{ingredient1, ingredient2}, 6.75f},
                {bun2, new Ingredient[]{ingredient1, ingredient1}, 8.00f},
                {bun2, new Ingredient[]{ingredient1}, 7.00f},
                {bun2, new Ingredient[]{}, 6.00f}
        });
    }

    @Test
    public void testGetPrice() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        for (Ingredient ingredient : ingredients) {
            burger.addIngredient(ingredient);
        }
        assertEquals(expectedPrice, burger.getPrice(), 0.01f);
    }
}
