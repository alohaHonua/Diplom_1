package ru.praktikum.tests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import ru.praktikum.Bun;
import ru.praktikum.Burger;
import ru.praktikum.Ingredient;
import ru.praktikum.IngredientType;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

//Класс сожердит тесты методов класса Burger
@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;

    @Mock
    private Bun bunGray;

    @Mock
    private Ingredient sauceChilli, sauceKetchup, fillingCheese, fillingPulledPork;

    @Before
    public void setUp(){
        burger = new Burger();
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
        boolean actual = burger.ingredients.contains(sauceChilli);

        assertTrue("В списке нет элементов!", actual);
    }

    @Test
    public void burgerRemoveIngredient(){
        burger.addIngredient(sauceChilli);
        burger.addIngredient(sauceKetchup);
        burger.addIngredient(fillingCheese);
        burger.removeIngredient(1);
        boolean actual = burger.ingredients.contains(sauceKetchup);

        assertFalse("В списке должно быть два элемента!", actual);
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
        when(bunGray.getPrice()).thenReturn(4.5f);
        when(sauceKetchup.getPrice()).thenReturn(5.0f);
        when(fillingCheese.getPrice()).thenReturn(4.7f);
        when(fillingPulledPork.getPrice()).thenReturn(10.5f);

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
        when(bunGray.getPrice()).thenReturn(4.5f);
        when(bunGray.getName()).thenReturn("Gray bun");

        when(sauceChilli.getPrice()).thenReturn(5.6f);
        when(sauceChilli.getType()).thenReturn(IngredientType.SAUCE);
        when(sauceChilli.getName()).thenReturn("Chilli");

        when(fillingCheese.getPrice()).thenReturn(4.7f);
        when(fillingCheese.getType()).thenReturn(IngredientType.FILLING);
        when(fillingCheese.getName()).thenReturn("Cheese");

        when(fillingPulledPork.getPrice()).thenReturn(10.5f);
        when(fillingPulledPork.getType()).thenReturn(IngredientType.FILLING);
        when(fillingPulledPork.getName()).thenReturn("Pulled Pork");

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
