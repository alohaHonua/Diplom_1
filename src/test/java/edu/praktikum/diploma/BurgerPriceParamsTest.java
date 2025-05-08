package edu.praktikum.diploma;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BurgerPriceParamsTest {
    private Burger burger;
    private Bun bun;
    private float bunPrice;
    private float expectedPrice;
    private List<Float> ingredientPrices;

    public BurgerPriceParamsTest(float bunPrice, List<Float> ingredientPrices, float expectedPrice) {
        this.bunPrice = bunPrice;
        this.ingredientPrices = ingredientPrices;
        this.expectedPrice = expectedPrice;
    }

    @Before
    public void setUp() {
        burger = new Burger();
        bun = Mockito.mock(Bun.class);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        burger.setBuns(bun);
        for (Float price : ingredientPrices) {
            Ingredient ingredient = Mockito.mock(Ingredient.class);
            Mockito.when(ingredient.getPrice()).thenReturn(price);
            burger.addIngredient(ingredient);
        }
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][] {
                {100f, Arrays.asList(100f, 100f), 400f},
                {200f, Arrays.asList(200f, 200f), 800f},
                {300f, Arrays.asList(300f, 100f), 1000f},
                {100f, Arrays.asList(0f, 200f), 400f},
                {200f, Arrays.asList(300f, 0f), 700f},
                {300f, Arrays.asList(0f), 600f},
                {0f, Arrays.asList(100f, 200f), 300f},
                {0f, Arrays.asList(0f), 0f}
        };
    }

    @Test
    public void testGetPrice() {
        assertEquals(expectedPrice, burger.getPrice(), 0);
    }
}
