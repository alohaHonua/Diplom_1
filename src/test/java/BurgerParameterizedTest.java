import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class BurgerParameterizedTest {
    private final float expectedPrice;
    private final Bun bun;
    private final Ingredient[] ingredients;

    public BurgerParameterizedTest(float expectedPrice, Bun bun, Ingredient[] ingredients) {
        this.expectedPrice = expectedPrice;
        this.bun = bun;
        this.ingredients = ingredients;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getData() {

        Bun bunMock = Mockito.mock(Bun.class);
        Mockito.when(bunMock.getPrice()).thenReturn(2.0f);

        Ingredient ingredientFirstMock = Mockito.mock(Ingredient.class);
        Mockito.when(ingredientFirstMock.getPrice()).thenReturn(1.3f);
        Ingredient ingredientSecondMock = Mockito.mock(Ingredient.class);
        Mockito.when(ingredientSecondMock.getPrice()).thenReturn(0.9f);

        return  Arrays.asList(new Object[][] {
                {4.0f, bunMock, new Ingredient[]{}},
                {5.3f, bunMock, new Ingredient[]{ingredientFirstMock}},
                {6.2f, bunMock, new Ingredient[]{ingredientFirstMock,ingredientSecondMock}},
        });
    }

    @Test
    public void getPriceTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        for (Ingredient ingredient : ingredients) {
            burger.addIngredient(ingredient);
        }
        assertEquals(expectedPrice, burger.getPrice(), 0.1);
    }
}
