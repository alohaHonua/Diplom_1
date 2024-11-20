package ru.yandex.diplom;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Ingredient ingredients;

    @Mock
    Bun bun;

    @Test
    public void shouldReturnTrueSetBunsTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void shouldReturnTrueAddIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredients);
        Assert.assertEquals(ingredients, burger.ingredients.get(0));
    }

    @Test
    public void shouldReturnTrueRemoveIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredients);
        burger.addIngredient(ingredients);
        burger.removeIngredient(0);
        assertEquals(ingredients, burger.ingredients.get(0));
        int exIngredientsSize = 1;
        assertEquals(exIngredientsSize, burger.ingredients.size());
    }

    @Test
    public void shouldReturnTrueMoveIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredients);
        burger.addIngredient(ingredients);
        burger.moveIngredient(0, 1);
        assertEquals(ingredients, burger.ingredients.get(0));
        int exIngredientsSize = 2;
        assertEquals(exIngredientsSize, burger.ingredients.size());
    }

    @Test
    public void shouldReturnTrueGetReceiptTest() {
        Burger burger = new Burger();

        Mockito.when(bun.getName()).thenReturn("baget");
        Mockito.when(bun.getPrice()).thenReturn(100.0f);

        Mockito.when(ingredients.getName()).thenReturn("sour cream");
        Mockito.when(ingredients.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredients.getPrice()).thenReturn(100.0f);

        Mockito.when(ingredients.getName()).thenReturn("dinosaur");
        Mockito.when(ingredients.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredients.getPrice()).thenReturn(100.0f);

        burger.setBuns(bun);
        burger.addIngredient(ingredients);
        burger.addIngredient(ingredients);
        StringBuilder exReceipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));

        for (Ingredient ingredient : burger.ingredients) {
            exReceipt.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                    ingredient.getName()));
        }

        exReceipt.append(String.format("(==== %s ====)%n", bun.getName()));
        exReceipt.append(String.format("%nPrice: %f%n", 400.0f));
        Assert.assertEquals(exReceipt.toString(), burger.getReceipt());
    }
}

