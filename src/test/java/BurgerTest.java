import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BurgerTest {

    private Bun bun;
    private Ingredient ingredient1;
    private Ingredient ingredient2;
    private Burger burger;

    @Before
    public void setUp() {
        burger = new Burger();

        // Используем моки для ингредиентов
        bun = mock(Bun.class);
        ingredient1 = mock(Ingredient.class);
        ingredient2 = mock(Ingredient.class);

        // Задаем поведение для моков
        when(bun.getPrice()).thenReturn(100f);
        when(ingredient1.getPrice()).thenReturn(50f);
        when(ingredient2.getPrice()).thenReturn(70f);
    }

    @Test
    public void testSetBuns() {
        burger.setBuns(bun);
        assertEquals("Проверка установки булочки", bun, burger.bun);
    }

    @Test
    public void testAddIngredient_IncreasesSize() {
        burger.addIngredient(ingredient1);
        assertEquals("Проверка увеличения списка ингредиентов", 1, burger.ingredients.size());
    }

    @Test
    public void testAddIngredient_ContainsAddedIngredient() {
        burger.addIngredient(ingredient1);
        assertTrue("Проверка наличия добавленного ингредиента", burger.ingredients.contains(ingredient1));
    }

    @Test
    public void testRemoveIngredient_DecreasesSize() {
        burger.addIngredient(ingredient1);
        burger.removeIngredient(0);
        assertEquals("Проверка уменьшения списка ингредиентов", 0, burger.ingredients.size());
    }

    @Test
    public void testRemoveIngredient_RemovesCorrectIngredient() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.removeIngredient(0);
        assertFalse("Проверка удаления ингредиента", burger.ingredients.contains(ingredient1));
    }

    @Test
    public void testMoveIngredient_ChangesPosition() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        assertEquals("Проверка перемещения ингредиента", ingredient1, burger.ingredients.get(1));
    }

    @Test
    public void testGetPrice_IncludesBunPrice() {
        burger.setBuns(bun);
        assertEquals("Проверка включения цены булочки", 100f * 2, burger.getPrice(), 0.01);
    }

    @Test
    public void testGetPrice_IncludesIngredientPrice() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        assertEquals("Проверка включения цены ингредиента", 50f, burger.getPrice() - 100f * 2, 0.01);
    }
}
