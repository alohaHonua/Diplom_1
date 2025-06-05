
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;

    @Mock
    private Bun mockBun;

    @Mock
    private Ingredient mockSauce;

    @Mock
    private Ingredient mockFilling;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void testSetBuns() {
        burger.setBuns(mockBun);
        assertSame(mockBun, burger.bun);
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(mockSauce);
        assertEquals(1, burger.ingredients.size());
        assertSame(mockSauce, burger.ingredients.get(0));
    }

    @Test
    public void testGetPrice() {
        when(mockBun.getPrice()).thenReturn(100f);
        when(mockSauce.getPrice()).thenReturn(50f);

        burger.setBuns(mockBun);
        burger.addIngredient(mockSauce);

        assertEquals(250f, burger.getPrice(), 0.01f);
        verify(mockBun).getPrice();
        verify(mockSauce).getPrice();
    }

    @Test
    public void testGetReceipt() {
        when(mockBun.getName()).thenReturn("black bun");
        when(mockSauce.getType()).thenReturn(IngredientType.SAUCE);
        when(mockSauce.getName()).thenReturn("hot sauce");

        burger.setBuns(mockBun);
        burger.addIngredient(mockSauce);

        String receipt = burger.getReceipt();

        assertTrue(receipt.contains("black bun"));
        assertTrue(receipt.contains("hot sauce"));
        assertTrue(receipt.contains("Price: "));

        verify(mockBun, atLeastOnce()).getName();
        verify(mockSauce).getType();
        verify(mockSauce).getName();
    }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(mockSauce);
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void testMoveIngredient() {
        burger.addIngredient(mockSauce);
        burger.addIngredient(mockFilling);
        burger.moveIngredient(0, 1);
        assertSame(mockFilling, burger.ingredients.get(0));
        assertSame(mockSauce, burger.ingredients.get(1));
    }
}
