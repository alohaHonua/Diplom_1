import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.jupiter.api.Assertions.*;

public class BurgerIngredientsTests {

    Burger burger;

    private static final IngredientType INGREDIENT_DEFAULT_TYPE = IngredientType.FILLING;
    private static final String INGREDIENT_DEFAULT_NAME = "Spicy-X";
    private static final float INGREDIENT_DEFAULT_PRICE = 0;

    @Test
    public void moveIngredientPositiveTest() {
        burger = new Burger();
        Ingredient ingredient1 = new Ingredient(INGREDIENT_DEFAULT_TYPE, INGREDIENT_DEFAULT_NAME, INGREDIENT_DEFAULT_PRICE);
        Ingredient ingredient2 = new Ingredient(INGREDIENT_DEFAULT_TYPE, INGREDIENT_DEFAULT_NAME, INGREDIENT_DEFAULT_PRICE);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        assertEquals(burger.ingredients.get(0), ingredient2);
        assertEquals(burger.ingredients.get(1), ingredient1);
    }

    @Test
    public void addIngredientPositiveTest() {
        burger = new Burger();
        Ingredient ingredient = new Ingredient(INGREDIENT_DEFAULT_TYPE, INGREDIENT_DEFAULT_NAME, INGREDIENT_DEFAULT_PRICE);
        burger.addIngredient(ingredient);
        assertTrue(burger.ingredients.contains(ingredient));
    }

    @Test
    public void removeIngredientPositiveTest() {
        burger = new Burger();
        Ingredient ingredient = new Ingredient(INGREDIENT_DEFAULT_TYPE, INGREDIENT_DEFAULT_NAME, INGREDIENT_DEFAULT_PRICE);
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertFalse(burger.ingredients.contains(ingredient));
    }
}
