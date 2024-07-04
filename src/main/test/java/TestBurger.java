import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static praktikum.parameters.Parameters.*;

@RunWith(MockitoJUnitRunner.class)
public class TestBurger {
    Burger burger = new Burger();

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    @Test
    public void testSetBuns() {
       Bun bun = new Bun(BUN_NAME, BUN_PRICE);
        burger.setBuns(bun);
        assertThat(burger.bun, is(notNullValue()));
    }

    @Test
    public void testAddIngredient() {
       Ingredient ingredient = new Ingredient(IngredientType.SAUCE, SAUCE_NAME, SAUCE_PRICE);
        burger.addIngredient(ingredient);
        assertThat(burger.ingredients.size(), is(1));
    }

    @Test
    public void testRemoveIngredient() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, SAUCE_NAME, SAUCE_PRICE);
        int burgerSizeBefore = burger.ingredients.size();
        burger.addIngredient(ingredient);
        burger.removeIngredient(burger.ingredients.size()-1);
        assertThat(burger.ingredients.size(), is(burgerSizeBefore));
    }

    @Test
    public void testMoveIngredient() {
        Ingredient ingredient_1 = new Ingredient(IngredientType.SAUCE, SAUCE_NAME, SAUCE_PRICE);
        Ingredient ingredient_2 = new Ingredient(IngredientType.FILLING, FILLING_NAME, FILLING_PRICE);
        burger.addIngredient(ingredient_1);
        burger.addIngredient(ingredient_2);
        burger.moveIngredient(burger.ingredients.size()-1, 0);
        assertThat(burger.ingredients.indexOf(ingredient_2), is(0));
    }

    @Test
    public void testGetPrice() {
        Bun bun = new Bun(BUN_NAME, BUN_PRICE);
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, SAUCE_NAME, SAUCE_PRICE);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        float finishPrice = bun.price * 2 + ingredient.getPrice();
        assertThat(burger.getPrice(), is(finishPrice));
    }

    @Test
    public void testGetReceipt() {
        Mockito.when(bun.getName()).thenReturn(BUN_NAME);
        Mockito.when(bun.getPrice()).thenReturn(BUN_PRICE);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn(SAUCE_NAME);
        Mockito.when(ingredient.getPrice()).thenReturn(SAUCE_PRICE);

        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        String testReceipt = burger.getReceipt();

        Mockito.verify(bun, Mockito.times(2)).getName();
        Mockito.verify(bun).getPrice();
        Mockito.verify(ingredient).getName();
        Mockito.verify(ingredient).getPrice();
        Mockito.verify(ingredient).getType();

        float finishPrice = BUN_PRICE * 2 + SAUCE_PRICE;

        assertThat(testReceipt,allOf(containsString(BUN_NAME)));
        assertThat(testReceipt,allOf(containsString(SAUCE_NAME)));
        assertThat(testReceipt, containsString(String.valueOf(finishPrice).replace('.',',')));
    }
}
