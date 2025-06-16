package praktikum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class BurgerTest {

    private Burger burger;
    private Bun bun;
    private Ingredient ingredient1;
    private Ingredient ingredient2;

    @BeforeEach
    public void setup() {
        burger = new Burger();
        bun = new Bun("Test Bun", 50f);
        ingredient1 = new Ingredient(IngredientType.SAUCE, "Sauce 1", 20f);
        ingredient2 = new Ingredient(IngredientType.FILLING, "Filling 1", 30f);
    }

    @Test
    public void testSetBuns() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(ingredient1);
        assertTrue(burger.ingredients.contains(ingredient1));
    }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.removeIngredient(0);
        assertFalse(burger.ingredients.contains(ingredient1));
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void testMoveIngredient() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        List<Ingredient> ingr = burger.ingredients;
        assertEquals(ingredient2, ingr.get(0));
        assertEquals(ingredient1, ingr.get(1));
    }

    @Test
    public void testGetPrice() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        // price = bun*2 + ingredient1 + ingredient2
        float expected = bun.getPrice() * 2 + ingredient1.getPrice() + ingredient2.getPrice();
        assertEquals(expected, burger.getPrice());
    }

    @Test
    public void testGetReceipt() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        String receipt = burger.getReceipt();

        assertTrue(receipt.contains(bun.getName()));
        assertTrue(receipt.toLowerCase().contains(ingredient1.getType().toString().toLowerCase()));
        assertTrue(receipt.contains(ingredient1.getName()));
        assertTrue(receipt.contains(ingredient2.getName()));
        assertTrue(receipt.contains(String.format("%f", burger.getPrice())));
    }
}
