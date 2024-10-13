package praktikum.burger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import praktikum.Bun;
import praktikum.Ingredient;
import praktikum.Burger;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BurgerParameterizedTest {

    private Burger burger;
    private Bun mockBun;
    private Ingredient mockIngredient1;
    private Ingredient mockIngredient2;

    private final float bunPrice;
    private final float ingredient1Price;
    private final float ingredient2Price;
    private final float expectedPrice;

    public BurgerParameterizedTest(float bunPrice, float ingredient1Price, float ingredient2Price, float expectedPrice) {
        this.bunPrice = bunPrice;
        this.ingredient1Price = ingredient1Price;
        this.ingredient2Price = ingredient2Price;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 100f, 50f, 75f, 100 * 2 + 50 + 75 }, // Пример 1
                { 150f, 60f, 80f, 150 * 2 + 60 + 80 }, // Пример 2
                { 120f, 55f, 70f, 120 * 2 + 55 + 70 }  // Пример 3
        });
    }

    @Before
    public void setUp() {
        burger = new Burger();
        mockBun = Mockito.mock(Bun.class);
        mockIngredient1 = Mockito.mock(Ingredient.class);
        mockIngredient2 = Mockito.mock(Ingredient.class);

        // Задаем моки цен
        Mockito.when(mockBun.getPrice()).thenReturn(bunPrice);
        Mockito.when(mockIngredient1.getPrice()).thenReturn(ingredient1Price);
        Mockito.when(mockIngredient2.getPrice()).thenReturn(ingredient2Price);
    }

    @Test
    public void testGetPrice() {
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        assertEquals(expectedPrice, burger.getPrice(), 0.01);
    }
}
