package praktikum;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class BurgerTest {

    private Burger burger;
    private Bun mockBun;
    private Ingredient mockFilling;
    private Ingredient mockSauce;

    @Before
    public void setUp() {
        burger = new Burger();
        mockBun = mock(Bun.class);
        mockFilling = mock(Ingredient.class);
        mockSauce = mock(Ingredient.class);
    }

    @Test
    public void setBunsTest() {
        when(mockBun.getName()).thenReturn("Sesame");
        burger.setBuns(mockBun);
        assertEquals("Sesame", burger.bun.getName());
    }

    @Test
    public void addIngredientTest() {
        when(mockFilling.getName()).thenReturn("Lettuce");
        when(mockFilling.getPrice()).thenReturn(1.0f);

        burger.addIngredient(mockFilling);

        assertEquals(1, burger.ingredients.size());
        assertEquals("Lettuce", burger.ingredients.get(0).getName());
    }

    @Test
    public void removeIngredientTest() {
        when(mockFilling.getName()).thenReturn("Lettuce");
        burger.addIngredient(mockFilling);

        assertEquals(1, burger.ingredients.size());

        burger.removeIngredient(0);

        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        when(mockFilling.getName()).thenReturn("Lettuce");
        when(mockSauce.getName()).thenReturn("Ketchup");

        burger.addIngredient(mockFilling);
        burger.addIngredient(mockSauce);

        assertEquals("Lettuce", burger.ingredients.get(0).getName());
        assertEquals("Ketchup", burger.ingredients.get(1).getName());

        burger.moveIngredient(0, 1); // Move "Lettuce" to index 1

        assertEquals("Ketchup", burger.ingredients.get(0).getName());
        assertEquals("Lettuce", burger.ingredients.get(1).getName());
    }

    @Test
    public void getPriceTest() {
        when(mockBun.getPrice()).thenReturn(2.0f);
        when(mockFilling.getPrice()).thenReturn(1.0f);
        when(mockSauce.getPrice()).thenReturn(0.5f);

        burger.setBuns(mockBun);
        burger.addIngredient(mockFilling);
        burger.addIngredient(mockSauce);

        float expectedPrice = 2.0f * 2 + 1.0f + 0.5f; // 4.0 + 1.0 + 0.5 = 5.5
        assertEquals(expectedPrice, burger.getPrice(), 0.01);
    }

    @Test
    public void testGetReceipt() {

        when(mockBun.getName()).thenReturn("Sesame");
        when(mockFilling.getName()).thenReturn("lettuce");
        when(mockSauce.getName()).thenReturn("ketchup");
        when(mockBun.getPrice()).thenReturn(2.0f);
        when(mockFilling.getPrice()).thenReturn(1.0f);
        when(mockSauce.getPrice()).thenReturn(0.5f);

        when(mockFilling.getType()).thenReturn(IngredientType.FILLING);
        when(mockSauce.getType()).thenReturn(IngredientType.SAUCE);


        burger.setBuns(mockBun);
        burger.addIngredient(mockFilling);
        burger.addIngredient(mockSauce);

        String expectedReceipt = String.format("(==== %s ====)%n", "Sesame") +
                String.format("= filling lettuce =%n") +
                String.format("= sauce ketchup =%n") +
                String.format("(==== %s ====)%n", "Sesame") +
                String.format("%nPrice: %.6f%n", 5.5f);

        assertEquals(expectedReceipt, burger.getReceipt());
    }
}