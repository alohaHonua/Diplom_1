package praktikum;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class BurgerTest {

    @Test
    public void testGetPrice() {
        Bun bun = mock(Bun.class);
        when(bun.getPrice()).thenReturn(40f);

        Ingredient ingredient1 = mock(Ingredient.class);
        when(ingredient1.getPrice()).thenReturn(20f);

        Ingredient ingredient2 = mock(Ingredient.class);
        when(ingredient2.getPrice()).thenReturn(15f);

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        float expectedPrice = bun.getPrice() * 2 + (ingredient1.getPrice() + ingredient2.getPrice());

        assertEquals(expectedPrice, burger.getPrice(), 0.01);
    }

    @Test
    public void testRemoveIngredient() {
        Burger burger = new Burger();

        Ingredient ingredient1 = new Ingredient(IngredientType.FILLING, "Lettuce", 25f);
        Ingredient ingredient2 = new Ingredient(IngredientType.SAUCE, "Ketchup", 15f);

        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        int initialIngredientCount = burger.ingredients.size();

        burger.removeIngredient(0);

        int updatedIngredientCount = burger.ingredients.size();

        assertEquals(initialIngredientCount - 1, updatedIngredientCount);
    }

    @Test
    public void testGetReceipt() {
        Bun bun = mock(Bun.class);
        when(bun.getName()).thenReturn("Sesame Bun");
        when(bun.getPrice()).thenReturn(40f);

        Ingredient ingredient1 = mock(Ingredient.class);
        when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient1.getName()).thenReturn("Tomato");
        when(ingredient1.getPrice()).thenReturn(20f);

        Ingredient ingredient2 = mock(Ingredient.class);
        when(ingredient2.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient2.getName()).thenReturn("Mayonnaise");
        when(ingredient2.getPrice()).thenReturn(15f);

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));
        receipt.append(String.format("= %s %s =%n", ingredient1.getType().toString().toLowerCase(), ingredient1.getName()));
        receipt.append(String.format("= %s %s =%n", ingredient2.getType().toString().toLowerCase(), ingredient2.getName()));
        receipt.append(String.format("(==== %s ====)%n", bun.getName()));
        receipt.append(String.format("%nPrice: %f%n", 115f));
        Assert.assertEquals(receipt.toString(), burger.getReceipt());
    }

    @Test
    public void testGetIngredients() {
        Burger burger = new Burger();

        Ingredient ingredient1 = new Ingredient(IngredientType.FILLING, "Cheese", 35f);
        Ingredient ingredient2 = new Ingredient(IngredientType.SAUCE, "BBQ Sauce", 18f);

        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        assertEquals(2, burger.ingredients.size());
    }

    @Test
    public void testMoveIngredient() {
        Burger burger = new Burger();

        Ingredient ingredient1 = new Ingredient(IngredientType.FILLING, "Bacon", 40f);
        Ingredient ingredient2 = new Ingredient(IngredientType.SAUCE, "Ketchup", 15f);

        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        burger.moveIngredient(0, 1);

        assertEquals(ingredient1, burger.ingredients.get(1));
    }
}
