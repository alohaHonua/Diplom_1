package tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;
import tests.base.ConstantsIngredientType;

import static tests.base.ConstantsForTests.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @InjectMocks
    private Burger burger;

    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredientOne, ingredientTwo;

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredient() {
        burger.addIngredient(ingredientOne);
        Assert.assertTrue(burger.ingredients.contains(ingredientOne));
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredientOne);
        burger.removeIngredient(0);
        Assert.assertFalse(burger.ingredients.contains(ingredientOne));
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(ingredientOne);
        burger.addIngredient(ingredientTwo);
        burger.moveIngredient(0, 1);
        Assert.assertEquals(1, burger.ingredients.indexOf(ingredientOne));
    }

    @Test
    public void getPriceTest() {
        Mockito.when(bun.getPrice()).thenReturn(BUN_PRICE);
        Mockito.when(ingredientOne.getPrice()).thenReturn(INGREDIENT_PRICE);
        burger.addIngredient(ingredientOne);
        float expectedPrice = BUN_PRICE * 2 + INGREDIENT_PRICE;
        Assert.assertEquals(expectedPrice, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptTest() {
        float price = BUN_PRICE * 2 + INGREDIENT_PRICE;
        String receipt = String.format("(==== %s ====)%n= %s %s =%n(==== %s ====)%n%nPrice: %f%n",
                BUN_NAME,
                ConstantsIngredientType.FILLING.toString().toLowerCase(),
                INGREDIENT_CHEESE,
                BUN_NAME,
                price
        );

        burger.addIngredient(ingredientOne);
        Mockito.when(bun.getPrice()).thenReturn(BUN_PRICE);
        Mockito.when(bun.getName()).thenReturn(BUN_NAME);
        Mockito.when(ingredientOne.getPrice()).thenReturn(INGREDIENT_PRICE);
        Mockito.when(ingredientOne.getName()).thenReturn(INGREDIENT_CHEESE);
        Mockito.when(ingredientOne.getType()).thenReturn(IngredientType.FILLING);
        Assert.assertEquals(receipt, burger.getReceipt());
    }
}