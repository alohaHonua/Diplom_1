package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.logging.Logger;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private static final String DEFAULT_BUN_NAME = "BLack bun";
    private static final float DEFAULT_BUN_PRICE = 20;
    private static final float DEFAULT_INGREDIENT_PRICE = 30;
    private static final float EXPECTED_BURGER_PRICE = 100;
    private static final String FIRST_INGREDIENT_NAME = "Ingredient 1";
    private static final String SECOND_INGREDIENT_NAME = "Ingredient 2";
    private static final String EXPECTED_RECEIPT = "(==== BLack bun ====)= filling Ingredient 1 == sauce Ingredient 2 =(==== BLack bun ====)Price: 100,000000";

    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient1;
    @Mock
    private Ingredient ingredient2;



    @Test
    public void setBuns() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient1);
        Assert.assertTrue(burger.ingredients.contains(ingredient1));
    }

    @Test
    public void removeIngredient() {
        Burger burger = new Burger();
        burger.ingredients.add(ingredient1);
        burger.removeIngredient(0);
        Assert.assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredient() {
        Burger burger = new Burger();
        burger.ingredients.addAll(List.of(ingredient1, ingredient2));
        burger.moveIngredient(1, 0);
        Assert.assertEquals(ingredient2, burger.ingredients.get(0));
        Assert.assertEquals(ingredient1, burger.ingredients.get(1));
    }

    @Test
    public void getPrice() {
        Mockito.when(bun.getPrice()).thenReturn(DEFAULT_BUN_PRICE);
        Mockito.when(ingredient1.getPrice()).thenReturn(DEFAULT_INGREDIENT_PRICE);
        Mockito.when(ingredient2.getPrice()).thenReturn(DEFAULT_INGREDIENT_PRICE);
        Burger burger = new Burger();
        burger.bun = bun;
        burger.ingredients.addAll(List.of(ingredient1, ingredient2));
        Assert.assertEquals(EXPECTED_BURGER_PRICE, burger.getPrice(), 0.0f);
        Mockito.verify(bun, Mockito.times(1)).getPrice();
        for (Ingredient ingredient : burger.ingredients) {
            Mockito.verify(ingredient, Mockito.times(1)).getPrice();
        }
    }

    @Test
    public void getReceipt() {
        Mockito.when(bun.getPrice()).thenReturn(DEFAULT_BUN_PRICE);
        Mockito.when(bun.getName()).thenReturn(DEFAULT_BUN_NAME);
        Mockito.when(ingredient1.getPrice()).thenReturn(DEFAULT_INGREDIENT_PRICE);
        Mockito.when(ingredient2.getPrice()).thenReturn(DEFAULT_INGREDIENT_PRICE);
        Mockito.when(ingredient1.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient2.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient1.getName()).thenReturn(FIRST_INGREDIENT_NAME);
        Mockito.when(ingredient2.getName()).thenReturn(SECOND_INGREDIENT_NAME);
        Burger burger = new Burger();
        burger.bun = bun;
        burger.ingredients.addAll(List.of(ingredient1, ingredient2));
        Assert.assertEquals(EXPECTED_RECEIPT, burger.getReceipt().replace("\n", "").replace("\r", ""));
        Mockito.verify(bun, Mockito.times(2)).getName();
        Mockito.verify(bun, Mockito.times(1)).getPrice();
        for (Ingredient ingredient : burger.ingredients) {
            Mockito.verify(ingredient, Mockito.times(1)).getPrice();
            Mockito.verify(ingredient, Mockito.times(1)).getType();
            Mockito.verify(ingredient, Mockito.times(1)).getName();
        }
    }
}