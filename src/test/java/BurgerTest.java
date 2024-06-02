import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BurgerTest {

    // Тест для проверки добавления ингредиента в бургер
    @Test
    public void testAddIngredient() {
        Burger burger = new Burger();
        Ingredient ketchup = new Ingredient(IngredientType.SAUCE, "ketchup", 50);

        burger.addIngredient(ketchup);
        List<Ingredient> ingredients = burger.ingredients;

        assertTrue("Список ингредиентов должен содержать добавленный ингредиент", ingredients.contains(ketchup));
    }

    // Тест для проверки удаления ингредиента из бургера
    @Test
    public void testRemoveIngredient() {
        Burger burger = new Burger();
        Ingredient sausage = new Ingredient(IngredientType.FILLING, "sausage", 300);

        burger.addIngredient(sausage);
        burger.removeIngredient(0);
        List<Ingredient> ingredients = burger.ingredients;

        assertTrue("Список ингредиентов должен быть пустым", ingredients.isEmpty());
    }

    // Тест для проверки перемещения ингредиента в бургере
    @Test
    public void testMoveIngredient() {
        Burger burger = new Burger();
        Ingredient sourCream = new Ingredient(IngredientType.SAUCE, "sour cream", 200);
        Ingredient cutlet = new Ingredient(IngredientType.FILLING, "cutlet", 100);

        burger.addIngredient(sourCream);
        burger.addIngredient(cutlet);

        burger.moveIngredient(0, 1);
        List<Ingredient> ingredients = burger.ingredients;

        assertEquals("Первый ингредиент должен быть котлета", cutlet, ingredients.get(0));
        assertEquals("Второй ингредиент должен быть сметана", sourCream, ingredients.get(1));
    }

    // Тест для проверки расчета цены бургера
    @Test
    public void testGetPrice() {
        Burger burger = new Burger();
        Bun bun = new Bun("white bun", 100);
        Ingredient hotSauce = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        Ingredient dinosaur = new Ingredient(IngredientType.FILLING, "dinosaur", 200);

        burger.setBuns(bun);
        burger.addIngredient(hotSauce);
        burger.addIngredient(dinosaur);

        assertEquals("Цена бургера должна быть 400", 500, burger.getPrice(), 0);
    }

    // Тест для проверки создания чека бургера
    @Test
    public void testGetReceipt() {
        Burger burger = new Burger();
        Bun bun = new Bun("black bun", 150);
        Ingredient chiliSauce = new Ingredient(IngredientType.SAUCE, "chili sauce", 300);
        Ingredient sausage = new Ingredient(IngredientType.FILLING, "sausage", 300);

        burger.setBuns(bun);
        burger.addIngredient(chiliSauce);
        burger.addIngredient(sausage);

        String expectedReceipt = "(==== black bun ====)\n" +
                "= sauce chili sauce =\n" +
                "= filling sausage =\n" +
                "(==== black bun ====)\n" +
                "\n" +
                "Price: 900,000000\n";

        assertEquals("Чек бургера должен быть верным", expectedReceipt, burger.getReceipt());
    }
}
