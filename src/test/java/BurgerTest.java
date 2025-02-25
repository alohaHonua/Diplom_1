import data.Names;
import data.Prices;
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

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredientSauce;

    @Mock
    private Ingredient ingredientFilling;

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
        List<Ingredient> expectedOrder = new ArrayList<>();
        expectedOrder.add(ingredientFilling);
        expectedOrder.add(ingredientSauce);

        burger.addIngredient(ingredientSauce);
        burger.addIngredient(ingredientFilling);
        burger.moveIngredient(0, 1);

        assertEquals(expectedOrder, burger.ingredients);
    }

    @Test
    public void getPriceThreeItemsPriceIsCorrect() {
        Mockito.when(bun.getPrice()).thenReturn(Prices.BUN_PRICE);
        Mockito.when(ingredientSauce.getPrice()).thenReturn(Prices.SAUCE_PRICE);
        Mockito.when(ingredientFilling.getPrice()).thenReturn(Prices.FILLING_PRICE);

        burger.setBuns(bun);
        burger.addIngredient(ingredientFilling);
        burger.addIngredient(ingredientSauce);

        assertEquals(Prices.EXPECTED_BURGER_PRICE, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptThreeItemsReceiptIsCorrect() {
        String formattedBurgerPrice = String.format("%f", Prices.EXPECTED_BURGER_PRICE);

        String expectedReceipt = String.format("(==== %s ====)%n" +
                        "= %s %s =%n" +
                        "= %s %s =%n" +
                        "(==== %s ====)%n" +
                        "%n" +
                        "Price: %s%n",
                Names.BUN_NAME,
                IngredientType.FILLING.toString().toLowerCase(), Names.FILLING_NAME,
                IngredientType.SAUCE.toString().toLowerCase(), Names.SAUCE_NAME,
                Names.BUN_NAME,
                formattedBurgerPrice
        );

        Mockito.when(bun.getName()).thenReturn(Names.BUN_NAME);
        Mockito.when(ingredientFilling.getName()).thenReturn(Names.FILLING_NAME);
        Mockito.when(ingredientSauce.getName()).thenReturn(Names.SAUCE_NAME);
        Mockito.when(bun.getPrice()).thenReturn(Prices.BUN_PRICE);
        Mockito.when(ingredientFilling.getPrice()).thenReturn(Prices.FILLING_PRICE);
        Mockito.when(ingredientSauce.getPrice()).thenReturn(Prices.SAUCE_PRICE);
        Mockito.when(ingredientFilling.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredientSauce.getType()).thenReturn(IngredientType.SAUCE);

        burger.setBuns(bun);
        burger.addIngredient(ingredientFilling);
        burger.addIngredient(ingredientSauce);

        assertEquals(expectedReceipt, burger.getReceipt());
    }
}
