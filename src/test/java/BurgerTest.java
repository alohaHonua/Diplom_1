import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BurgerTest {

    private Burger burger;
    private Bun bun;
    private Ingredient ingredient1;
    private Ingredient ingredient2;

    @Before
    public void setUp() {
        burger = new Burger();

        // Мокаем булку и ингредиенты
        bun = mock(Bun.class);
        ingredient1 = mock(Ingredient.class);
        ingredient2 = mock(Ingredient.class);

        when(bun.getName()).thenReturn("Булочка");
        when(bun.getPrice()).thenReturn(2.0f);

        when(ingredient1.getName()).thenReturn("Котлета");
        when(ingredient1.getPrice()).thenReturn(3.0f);
        when(ingredient1.getType()).thenReturn(IngredientType.FILLING);

        when(ingredient2.getName()).thenReturn("Соус");
        when(ingredient2.getPrice()).thenReturn(1.0f);
        when(ingredient2.getType()).thenReturn(IngredientType.SAUCE);

        burger.setBuns(bun);
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(ingredient1);
        assertEquals(1, burger.ingredients.size());
        assertEquals(ingredient1, burger.ingredients.get(0));
    }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(ingredient1);
        burger.removeIngredient(0);
        assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void testMoveIngredient() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(1, 0);

        List<Ingredient> ingredients = burger.ingredients;
        assertEquals(ingredient2, ingredients.get(0));
        assertEquals(ingredient1, ingredients.get(1));
    }

    @Test
    public void testGetPrice() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        float expected = 2.0f * 2 + 3.0f + 1.0f;
        assertEquals(expected, burger.getPrice(), 0.001f);
    }

    @Test
    public void testGetReceipt() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        String receipt = burger.getReceipt();

        assertTrue(receipt.contains("Булочка"));
        assertTrue(receipt.contains("filling Котлета"));
        assertTrue(receipt.contains("sauce Соус"));
        assertTrue(receipt.contains("Price: 8"));
    }
}
