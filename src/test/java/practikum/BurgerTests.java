package praktikum;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class BurgerTests {

    private Burger burger;
    private Bun bun;
    private Ingredient ingredient1;
    private Ingredient ingredient2;
    private Ingredient ingredient3;

    @Before
    public void setUp() {
        burger = new Burger();
        bun = new Bun("white bun", 50);
        ingredient1 = new Ingredient(IngredientType.SAUCE, "Ketchup", 20);
        ingredient2 = new Ingredient(IngredientType.FILLING, "Beef", 100);
        ingredient3 = new Ingredient(IngredientType.FILLING, "Cheese", 30);
    }

    @Test
    public void testSetBuns() {
        burger.setBuns(bun);
        assertEquals("white bun", burger.bun.getName());
        assertEquals(50, burger.bun.getPrice(), 0.001);
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        List<Ingredient> ingredients = burger.ingredients;
        assertEquals(2, ingredients.size());
        assertEquals(ingredient1, ingredients.get(0));
        assertEquals(ingredient2, ingredients.get(1));
    }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.removeIngredient(0);
        List<Ingredient> ingredients = burger.ingredients;
        assertEquals(1, ingredients.size());
        assertEquals(ingredient2, ingredients.get(0));
    }

    @Test
    public void testMoveIngredient() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        burger.moveIngredient(2, 0);
        List<Ingredient> ingredients = burger.ingredients;
        assertEquals(ingredient3, ingredients.get(0));
        assertEquals(ingredient1, ingredients.get(1));
        assertEquals(ingredient2, ingredients.get(2));
    }

    @Test
    public void testGetPrice() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        float expectedPrice = bun.getPrice() * 2 + ingredient1.getPrice() + ingredient2.getPrice();
        assertEquals(expectedPrice, burger.getPrice(), 0.001);
    }

    @Test
    public void testGetReceipt() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        String expectedReceipt = String.format(
                "(==== %s ====)%n= %s %s =%n= %s %s =%n= %s %s =%n(==== %s ====)%n%nPrice: %.6f%n",
                bun.getName(),
                ingredient1.getType().toString().toLowerCase(), ingredient1.getName(),
                ingredient2.getType().toString().toLowerCase(), ingredient2.getName(),
                ingredient3.getType().toString().toLowerCase(), ingredient3.getName(),
                bun.getName(),
                burger.getPrice()
        );
        assertEquals(expectedReceipt, burger.getReceipt());
    }
}