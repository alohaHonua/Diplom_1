package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;

    @Test
    public void setBuns() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        assertEquals("Bun should be set correctly", bun, burger.bun);
    }

    @Test
    public void addIngredient() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Special Sauce", 0.5f);
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        assertEquals("Ingredient should be added", List.of(ingredient), burger.ingredients);
    }

    @Test
    public void removeIngredient() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Grilled Veggie", 1.5f);
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertEquals("Ingredient list should be empty after removal", new ArrayList<>(), burger.ingredients);
    }

    @Test
    public void moveIngredient() {
        Ingredient ingredient1 = new Ingredient(IngredientType.FILLING, "Tomato", 0.2f);
        Ingredient ingredient2 = new Ingredient(IngredientType.SAUCE, "Ketchup", 0.1f);
        Burger burger = new Burger();
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        assertEquals("Ingredients should be swapped", List.of(ingredient2, ingredient1), burger.ingredients);
    }

    @Test
    public void getReceipt() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Mustard", 0.3f);
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        Bun customBun = new Bun("Whole Wheat", 2.5f);
        burger.setBuns(customBun);

        String expectedReceipt = String.format(
                "(==== %s ====)%n= sauce Mustard =%n(==== %s ====)%n%nPrice: %.2f%n",
                customBun.getName(), customBun.getName(), customBun.getPrice() * 2 + ingredient.getPrice()
        );

        assertEquals("Receipt should match expected format", expectedReceipt, burger.getReceipt());
    }
}