package praktikum;

import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class BurgerTest {
    private Burger burger;
    private Bun bun;
    private Ingredient ingredient1;
    private Ingredient ingredient2;

    @Before
    public void setUp() {
        burger = new Burger();
        bun = new Bun("Белая булочка", 100);
        ingredient1 = new Ingredient(IngredientType.SAUCE, "Кетчуп", 50);
        ingredient2 = new Ingredient(IngredientType.FILLING, "Котлета", 200);
    }

    @Test
    public void setBunsShouldSetBunCorrectly() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientShouldAddToIngredientsList() {
        burger.addIngredient(ingredient1);
        assertEquals(1, burger.ingredients.size());
        assertSame(ingredient1, burger.ingredients.get(0));
    }

    @Test
    public void removeIngredientShouldRemoveFromList() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.removeIngredient(0);
        assertEquals(1, burger.ingredients.size());
        assertSame(ingredient2, burger.ingredients.get(0));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeIngredientWithInvalidIndexShouldThrowException() {
        burger.removeIngredient(0);
    }

    @Test
    public void moveIngredientShouldChangePosition() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        assertSame(ingredient2, burger.ingredients.get(0));
        assertSame(ingredient1, burger.ingredients.get(1));
    }

    @Test
    public void getPriceShouldCalculateCorrectly() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        float expected = bun.getPrice() * 2 + ingredient1.getPrice() + ingredient2.getPrice();
        assertEquals(expected, burger.getPrice(), 0.001);
    }

    @Test
    public void getReceiptShouldReturnCorrectFormat() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        String expected = String.format(
                "(==== Белая булочка ====)%n" +
                        "= sauce Кетчуп =%n" +
                        "= filling Котлета =%n" +
                        "(==== Белая булочка ====)%n%n" +
                        "Price: %f%n",
                burger.getPrice()
        );

        assertEquals(expected, burger.getReceipt());
    }

    @Test
    public void emptyBurgerShouldHaveZeroPrice() {
        burger.setBuns(bun);
        assertEquals(bun.getPrice() * 2, burger.getPrice(), 0.001);
    }

    @Test
    public void emptyBurgerReceiptShouldShowOnlyBuns() {
        burger.setBuns(bun);

        String expected = String.format(
                "(==== Белая булочка ====)%n" +
                        "(==== Белая булочка ====)%n%n" +
                        "Price: %f%n",
                burger.getPrice()
        );

        assertEquals(expected, burger.getReceipt());
    }
}