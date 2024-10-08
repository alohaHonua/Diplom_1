package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Burger burger;

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredientSauce;

    @Mock
    Ingredient ingredientFilling;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void addIngredientOneSauceAmountIsCorrect() {
        List<Ingredient> expectedIngredients = new ArrayList<>();
        expectedIngredients.add(ingredientSauce);
        burger.addIngredient(ingredientSauce);
        assertEquals(expectedIngredients.size(), burger.ingredients.size());

    }

    @Test
    public void removeIngredientOneSauceZeroAmount() {
        burger.addIngredient(ingredientSauce);
        burger.removeIngredient(0);
        assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientReplaceItemsOrderIsCorrect() {
        List<Ingredient> expectedOrder = new ArrayList<>(2);
        expectedOrder.add(ingredientFilling);
        expectedOrder.add(ingredientSauce);

        burger.addIngredient(ingredientSauce);
        burger.addIngredient(ingredientFilling);
        burger.moveIngredient(0, 1);
        assertEquals(expectedOrder, burger.ingredients);
    }

    @Test
    public void getPriceThreeItemsPriceIsCorrect() {
        Mockito.when(bun.getPrice()).thenReturn(Price.BUN_PRICE);
        Mockito.when(ingredientSauce.getPrice()).thenReturn(Price.SAUCE_PRICE);
        Mockito.when(ingredientFilling.getPrice()).thenReturn(Price.FILLING_PRICE);
        float expectedBurgerPrice = Price.EXPECTED_BURGER_PRICE;

        burger.setBuns(bun);
        burger.addIngredient(ingredientFilling);
        burger.addIngredient(ingredientSauce);

        assertEquals(expectedBurgerPrice, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptThreeItemsReceiptIsCorrect() {
        String expectedReceipt;
        String formattedBurgerPrice = String.format("%f%n", Price.EXPECTED_BURGER_PRICE);
        expectedReceipt = String.format("(==== %s ====)%n= %s %s =%n= %s %s =%n" + "(==== %s ====)%n%nPrice: %s",
                Names.BUN_NAME,
                IngredientType.FILLING.toString().toLowerCase(), Names.FILLING_NAME,
                IngredientType.SAUCE.toString().toLowerCase(), Names.SAUCE_NAME,
                Names.BUN_NAME,
                formattedBurgerPrice);

        Mockito.when(bun.getName()).thenReturn(Names.BUN_NAME);
        Mockito.when(ingredientFilling.getName()).thenReturn(Names.FILLING_NAME);
        Mockito.when(ingredientSauce.getName()).thenReturn(Names.SAUCE_NAME);
        Mockito.when(bun.getPrice()).thenReturn(Price.BUN_PRICE);
        Mockito.when(ingredientFilling.getPrice()).thenReturn(Price.FILLING_PRICE);
        Mockito.when(ingredientSauce.getPrice()).thenReturn(Price.SAUCE_PRICE);
        Mockito.when(ingredientFilling.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredientSauce.getType()).thenReturn(IngredientType.SAUCE);

        burger.setBuns(bun);
        burger.addIngredient(ingredientFilling);
        burger.addIngredient(ingredientSauce);
        assertEquals(expectedReceipt, burger.getReceipt());
    }

}