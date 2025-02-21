import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class BurgerModificationTest {

    private Burger burger;
    private Bun bun;

    @Before
    public void setUp() {
        bun = new Bun("regular bun", 50);
        burger = new Burger();
        burger.setBuns(bun);
    }

    @Test
    public void testAddIngredient() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "lettuce", 10);
        burger.addIngredient(ingredient);

        Assert.assertEquals(1, burger.ingredients.size());
        Assert.assertEquals(ingredient, burger.ingredients.get(0));
    }

    @Test
    public void testRemoveIngredient() {
        Ingredient ingredient1 = new Ingredient(IngredientType.FILLING, "tomato", 15);
        Ingredient ingredient2 = new Ingredient(IngredientType.FILLING, "onion", 20);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        burger.removeIngredient(0); // Удаляем первый ингредиент

        Assert.assertEquals(1, burger.ingredients.size());
        Assert.assertEquals(ingredient2, burger.ingredients.get(0));
    }

    @Test
    public void testMoveIngredient() {
        Ingredient ingredient1 = new Ingredient(IngredientType.FILLING, "bacon", 30);
        Ingredient ingredient2 = new Ingredient(IngredientType.FILLING, "egg", 25);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        burger.moveIngredient(0, 1); // Перемещаем "bacon" (индекс 0) на позицию 1

        Assert.assertEquals(ingredient2, burger.ingredients.get(0)); // Должен быть "egg"
        Assert.assertEquals(ingredient1, burger.ingredients.get(1)); // Должен быть "bacon"
    }
}