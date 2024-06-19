package ru.praktikum.tests;

import org.junit.Before;
import org.junit.Test;
import ru.praktikum.Bun;
import ru.praktikum.Burger;
import ru.praktikum.Ingredient;
import ru.praktikum.IngredientType;
import static org.junit.Assert.assertEquals;

public class BurgerTest {

    private Burger burger;

    private Bun bunGray;
    private Ingredient sauceChilli;
    private Ingredient sauceKetchup;
    private Ingredient fillingCheese;
    private Ingredient fillingPulledPork;

    @Before
    public void setUp(){
        burger = new Burger();
        bunGray = new Bun("Gray bun", 4.5F);
        sauceChilli = new Ingredient(IngredientType.SAUCE, "Chilli", 5.6F);
        sauceKetchup = new Ingredient(IngredientType.SAUCE, "Ketchup", 5.0F);
        fillingCheese = new Ingredient(IngredientType.FILLING, "Cheese", 4.7F);
        fillingPulledPork = new Ingredient(IngredientType.FILLING, "Pulled Pork", 10.5F);
    }

    @Test
    public void burgerSetBunsTest(){
        burger.setBuns(bunGray);
        Bun expected = bunGray;
        Bun actual = burger.bun;
        assertEquals("Булочки не совпадают", expected, actual);
    }

    @Test
    public void burgerAddIngredientTest(){
        burger.addIngredient(sauceChilli);
        int expected = 1;
        int actual = burger.ingredients.size();
        assertEquals("В списке нет элементов!", expected, actual);
    }

    @Test
    public void burgerRemoveIngredient(){
        burger.addIngredient(sauceChilli);
        burger.addIngredient(sauceKetchup);
        burger.addIngredient(fillingCheese);

        burger.removeIngredient(1);

        int expected = 2;
        int actual = burger.ingredients.size();
        assertEquals("В списке должно быть два элемента!", expected, actual);
    }

    @Test
    public void burgerMoveIngredientTest(){
        burger.addIngredient(sauceChilli);
        burger.addIngredient(sauceKetchup);
        burger.addIngredient(fillingCheese);

        burger.moveIngredient(2, 0);

        Ingredient expected = fillingCheese;
        Ingredient actual = burger.ingredients.get(0);
        assertEquals("На 0 индексе должен быть сыр!", expected, actual);
    }

    @Test
    public void burgerGetPriceTest(){
        burger.setBuns(bunGray);
        burger.addIngredient(sauceKetchup);
        burger.addIngredient(fillingCheese);
        burger.addIngredient(fillingPulledPork);

        Float expected = 29.2F;
        Float actual = burger.getPrice();
        assertEquals("Суммы не совпадают!", expected, actual);
    }

    @Test
    public void burgerGetReceipt(){
        burger.setBuns(bunGray);
        burger.addIngredient(sauceChilli);
        burger.addIngredient(fillingCheese);
        burger.addIngredient(fillingPulledPork);

        String expected =
                "(==== Gray bun ====)\r\n" +
                "= sauce Chilli =\r\n" +
                "= filling Cheese =\r\n" +
                "= filling Pulled Pork =\r\n" +
                "(==== Gray bun ====)\r\n" +
                        "\r\n" +
                "Price: 29,799999";

        String actual = burger.getReceipt();
        assertEquals("Рецепты не совпадают!", expected.trim(), actual.trim());
    }
}
