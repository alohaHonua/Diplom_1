import org.junit.Before;
import org.junit.Test;
import praktikum.*;

import static org.junit.Assert.*;

public class BurgerTests {

    private Burger burger;
    private Database database;

    @Before
    public void setUp() {
        burger = new Burger();
        database = new Database();
    }

    @Test
    public void testSetBuns() {
        Bun bun = database.availableBuns().get(0); // black bun
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void testAddIngredient() {
        Ingredient ingredient = database.availableIngredients().get(0); // hot sauce
        burger.addIngredient(ingredient);
        assertTrue(burger.ingredients.contains(ingredient));
    }

    @Test
    public void testRemoveIngredient() {
        Ingredient ingredient1 = database.availableIngredients().get(0); // hot sauce
        Ingredient ingredient2 = database.availableIngredients().get(1); // sour cream
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        burger.removeIngredient(0);
        assertFalse(burger.ingredients.contains(ingredient1));
        assertTrue(burger.ingredients.contains(ingredient2));
    }

    @Test
    public void testMoveIngredient() {
        Ingredient ingredient1 = database.availableIngredients().get(0); // hot sauce
        Ingredient ingredient2 = database.availableIngredients().get(1); // sour cream
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        burger.moveIngredient(0, 1); // move hot sauce to index 1
        assertEquals(ingredient2, burger.ingredients.get(0)); // sour cream should be at index 0
        assertEquals(ingredient1, burger.ingredients.get(1)); // hot sauce should be at index 1
    }

    @Test
    public void testGetPrice() {
        Bun bun = database.availableBuns().get(0); // black bun
        burger.setBuns(bun);

        Ingredient ingredient1 = database.availableIngredients().get(0); // hot sauce
        Ingredient ingredient2 = database.availableIngredients().get(1); // sour cream
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        float expectedPrice = bun.getPrice() * 2 + ingredient1.getPrice() + ingredient2.getPrice();
        assertEquals(expectedPrice, burger.getPrice(), 0.0001f);
    }

    @Test
    public void testGetReceipt() {
        Bun bun = database.availableBuns().get(0); // black bun
        burger.setBuns(bun);

        Ingredient ingredient1 = database.availableIngredients().get(0); // hot sauce
        burger.addIngredient(ingredient1);

        String expectedReceipt = String.format("(==== %s ====)%n= sauce hot sauce =%n(==== %s ====)%n%nPrice: %f%n",
                bun.getName(), bun.getName(), burger.getPrice());

        assertEquals(expectedReceipt, burger.getReceipt());
    }
}

