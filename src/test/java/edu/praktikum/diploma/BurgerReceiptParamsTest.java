package edu.praktikum.diploma;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class BurgerReceiptParamsTest {
    private Burger burger;
    private Bun bun;
    private List<Ingredient> ingredients;
    private String expectedReceipt;

    public BurgerReceiptParamsTest(Bun bun, List<Ingredient> ingredients, String expectedReceipt) {
        this.bun = bun;
        this.ingredients = ingredients;
        this.expectedReceipt = expectedReceipt;
    }

    @Before
    public void setUp() {
        burger = new Burger();
        burger.setBuns(bun);
        ingredients.forEach(burger::addIngredient);
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        Bun bun1 = Mockito.mock(Bun.class);
        Mockito.when(bun1.getName()).thenReturn("black bun");
        Mockito.when(bun1.getPrice()).thenReturn(100f);

        Ingredient sauce = Mockito.mock(Ingredient.class);
        Mockito.when(sauce.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(sauce.getName()).thenReturn("sour cream");
        Mockito.when(sauce.getPrice()).thenReturn(200f);

        Ingredient filling = Mockito.mock(Ingredient.class);
        Mockito.when(filling.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(filling.getName()).thenReturn("cutlet");
        Mockito.when(filling.getPrice()).thenReturn(100f);

        return new Object[][] {
                {bun1, Arrays.asList(sauce), "(==== black bun ====)\n= sauce sour cream =\n(==== black bun ====)\n\nPrice: 400,000000\n"},
                {bun1, Arrays.asList(filling), "(==== black bun ====)\n= filling cutlet =\n(==== black bun ====)\n\nPrice: 300,000000\n"},
                {bun1, Arrays.asList(filling, sauce), "(==== black bun ====)\n= filling cutlet =\n= sauce sour cream =\n(==== black bun ====)\n\nPrice: 500,000000\n"},
                {bun1, Arrays.asList(), "(==== black bun ====)\n(==== black bun ====)\n\nPrice: 200,000000\n"}
        };
    }

    @Test
    public void testGetReceipt() {
        String normalizedExpectedReceipt = expectedReceipt.replace("\r\n", "\n").replace("\r", "\n");
        String normalizedActualReceipt = burger.getReceipt().replace("\r\n", "\n").replace("\r", "\n");

        assertEquals("Информация в чеке некорректна", normalizedExpectedReceipt, normalizedActualReceipt);
    }
}
