package praktikum;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BurgerTest {

    @Mock
    Ingredient ingredient;

    @Mock
    Bun bun;

    @Test
    @DisplayName("Проверка того, что булочка передана в бургер")
    public void setBuns() {
        Burger burger = new Burger();
        burger.setBuns(new Bun("Bulka", 45.67F));

        assertTrue("Bulka".equals(burger.bun.getName()));
    }

    @Test
    @DisplayName("Добавление ингредиента")
    public void addIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        Assert.assertTrue(burger.ingredients.size() == 2);
    }

    @Test
    @DisplayName("Проверка на удаление ингредиента")
    public void removeIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.removeIngredient(1);
        Assert.assertTrue(burger.ingredients.size() == 1);
    }

    @Test
    @DisplayName("Проверка на замену ингредиента")
    public void moveIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.moveIngredient(2, 1);
        Assert.assertTrue(burger.ingredients.size() == 3);
    }

    @Test
    @DisplayName("Расчет стоимости бургера")
    public void getPrice() {
        Burger burger = new Burger();
        Database database = new Database();
        List<Ingredient> ingredients = database.availableIngredients();
        burger.addIngredient(ingredients.get(0));
        burger.addIngredient(ingredients.get(4));
        burger.setBuns(database.availableBuns().get(1));
        float priceBurgerPlan = 100 + 200 + 200 * 2;
        float priceBurger = burger.getPrice();
        assertEquals(priceBurger, priceBurgerPlan, 0.001F);
    }

    @Test
    @DisplayName("Печать чека для бургера")
    public void getReceipt() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        Database database = new Database();
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(database.availableIngredients().get(2));
        ingredients.add(database.availableIngredients().get(3));
        burger.setBuns(database.availableBuns().get(1));
        burger.ingredients = ingredients;
        assertNotNull(burger.getReceipt());
    }
}
