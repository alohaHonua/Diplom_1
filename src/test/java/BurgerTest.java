import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Locale;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

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

        when(bun.getPrice()).thenReturn(100f);
        when(bun.getName()).thenReturn("black bun");
        when(ingredient1.getPrice()).thenReturn(50f);
        when(ingredient1.getName()).thenReturn("sauce");
        when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient2.getPrice()).thenReturn(75f);
        when(ingredient2.getName()).thenReturn("cutlet");
        when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
    }

    @Test
    public void testSetBuns() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
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
        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void testMoveIngredient() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        assertEquals(ingredient2, burger.ingredients.get(0));
        assertEquals(ingredient1, burger.ingredients.get(1));
    }

    @Test
    public void testGetPrice() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        assertEquals(325, burger.getPrice(), 0);
    }

    @Test
    public void testGetReceipt() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        String receipt = burger.getReceipt();

        // Проверка взаимодействий с моками
        verify(bun, times(2)).getName();
        verify(bun, times(1)).getPrice();
        verify(ingredient1, times(1)).getName();
        verify(ingredient1, times(1)).getType();
        verify(ingredient1, times(1)).getPrice();
        verify(ingredient2, times(1)).getName();
        verify(ingredient2, times(1)).getType();
        verify(ingredient2, times(1)).getPrice();

        // Проверка частей чека
        assertTrue(receipt.contains("(==== black bun ====)"));
        assertTrue(receipt.contains("= sauce sauce ="));
        assertTrue(receipt.contains("= filling cutlet ="));
        assertTrue(receipt.contains("(==== black bun ====)"));
        assertTrue(receipt.contains(String.format(Locale.US, "Price: %.6f", 325f).replace('.', ',')));
    }
}
