package edu.praktikum.diploma;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class BurgerTest {
    private Burger burger;
    private Bun bun;
    private Ingredient ingredient1;
    private Ingredient ingredient2;

    @Before
    public void setUp() {
        burger = new Burger();
        bun = mock(Bun.class);
        ingredient1 = mock(Ingredient.class);
        ingredient2 = mock(Ingredient.class);
    }

    @Test
    public void testSetBuns() {
        Mockito.when(bun.getName()).thenReturn("red bun");
        Mockito.when(bun.getPrice()).thenReturn(300f);
        burger.setBuns(bun);
        assertEquals("Выбранная булочка не установлена", bun, burger.bun);
        assertEquals("Название булочки отличается", "red bun", burger.bun.getName());
        assertEquals(300f, burger.bun.getPrice(), 0);
    }

    @Test
    public void testAddIngredient() {
        burger.setBuns(bun);
        assertEquals("Количество ингредиентов не равно 0", 0, burger.ingredients.size());
        burger.addIngredient(ingredient1);
        assertEquals("Количество ингредиентов не равно 1", 1, burger.ingredients.size());
        burger.addIngredient(ingredient2);
        assertEquals("Количество ингредиентов не равно 2", 2, burger.ingredients.size());
    }

    @Test
    public void testRemoveSingleIngredient() {
        burger.addIngredient(ingredient1);
        burger.removeIngredient(0);
        assertEquals("Количество ингредиентов не равно 0", 0, burger.ingredients.size());
    }

    @Test
    public void testRemoveIngredientFromList() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.removeIngredient(1);
        assertEquals("Количество ингредиентов не равно 1", 1, burger.ingredients.size());
        burger.removeIngredient(0);
        assertEquals("Количество ингредиентов не равно 0", 0, burger.ingredients.size());
    }

    @Test
    public void testMoveIngredient() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0,1);
        List<Ingredient> actualIngredients = burger.ingredients;
        assertEquals("Неверная позиция первого ингредиента", ingredient1, actualIngredients.get(1));
        assertEquals("Неверная позиция второго ингредиента", ingredient2, actualIngredients.get(0));

    }

}
