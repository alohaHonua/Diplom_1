import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;

public class BurgersTest {

    @Test
    public void testToSetBuns() {
        Bun bun = new Bun("white bun", 200);
        Burger burger = new Burger();
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void testToAddIngredient() {
        Ingredient ingredient1 = new Ingredient(IngredientType.FILLING, "cheese", 50);
        Burger burger = new Burger();
        burger.addIngredient(ingredient1);
        assertEquals(1, burger.ingredients.size());
        assertEquals(ingredient1, burger.ingredients.get(0));
    }

    @Test
    public void testToRemoveIngredient() {
        Ingredient ingredient1 = new Ingredient(IngredientType.FILLING, "cheese", 50);
        Ingredient ingredient2 = new Ingredient(IngredientType.SAUCE, "ketchup", 30);
        Burger burger = new Burger();
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.removeIngredient(0);
        assertEquals(1, burger.ingredients.size());
        assertEquals(ingredient2, burger.ingredients.get(0));
    }

    @Test
    public void testToMoveIngredient() {
        Ingredient ingredient1 = new Ingredient(IngredientType.FILLING, "cheese", 50);
        Ingredient ingredient2 = new Ingredient(IngredientType.SAUCE, "ketchup", 30);
        Burger burger = new Burger();
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        assertEquals(ingredient2, burger.ingredients.get(0));
        assertEquals(ingredient1, burger.ingredients.get(1));
    }

    @Test
    public void testToGetPrice() {
        Bun bun = new Bun("white bun", 200);
        Ingredient ingredient1 = new Ingredient(IngredientType.FILLING, "cheese", 50);
        Ingredient ingredient2 = new Ingredient(IngredientType.SAUCE, "ketchup", 30);

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        assertEquals(480, burger.getPrice(), 0.001);
    }

    @Test
    public void testToGetReceipt() {
        Bun bun = new Bun("white bun", 200);
        Ingredient ingredient1 = new Ingredient(IngredientType.FILLING, "cheese", 50);
        Ingredient ingredient2 = new Ingredient(IngredientType.SAUCE, "ketchup", 30);

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        String expectedReceipt = "(==== white bun ====)\n" +
                "= filling cheese =\n" +
                "= sauce ketchup =\n" +
                "(==== white bun ====)\n" +
                "\n" +
                "Price: 480,000000";

        assertEquals(expectedReceipt.trim(), burger.getReceipt().trim());
    }
}
