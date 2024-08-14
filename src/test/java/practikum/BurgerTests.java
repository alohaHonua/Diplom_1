package practikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTests {

    private Burger burger;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Test
    public void checkSetBuns() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void checkAddIngredient() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        assertEquals(2, burger.ingredients.size());
    }

    @Test
    public void checkRemoveIngredient() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void checkMoveIngredient() {
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "горчица", 50));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "огурец", 35));
        burger.moveIngredient(0, 1);
        float expectedPriceOfIngredient = 35;
        float actualPriceOfIngredient = burger.ingredients.get(0).price;
        assertEquals(expectedPriceOfIngredient, actualPriceOfIngredient, 0.0);
    }

    @Test
    public void checkGetPrice() {
        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(ingredient.getPrice()).thenReturn(75F);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        float expectedPrice = 350F;
        float actualPrice = burger.getPrice();
        assertEquals(expectedPrice, actualPrice, 0.0);
    }

    @Test
    public void checkGetReceipt() {
        Mockito.when(bun.getName()).thenReturn("sesame bun");
        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn("mustard");
        Mockito.when(ingredient.getPrice()).thenReturn(100F);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        String expectedReceipt = "(==== sesame bun ====)\r\n= filling mustard =\r\n(==== sesame bun ====)\r\n\r\nPrice: 300,000000\r\n";
        String actualReceipt = burger.getReceipt();

        assertEquals("Неправильный рецепт", expectedReceipt, actualReceipt);
    }
}