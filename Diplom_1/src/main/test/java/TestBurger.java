package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class TestBurger {

    private Burger burger;
    private Bun mockBun;
    private Ingredient mockIngredient1;
    private Ingredient mockIngredient2;

    @Before
    public void setUp() {
        burger = new Burger();
        mockBun = Mockito.mock(Bun.class);
        mockIngredient1 = Mockito.mock(Ingredient.class);
        mockIngredient2 = Mockito.mock(Ingredient.class);
    }

    @Test
    public void testSetBuns() {
        when(mockBun.getName()).thenReturn("Sesame Bun");
        when(mockBun.getPrice()).thenReturn(1.99f);

        burger.setBuns(mockBun);

        assertEquals("Wrong bun", mockBun, burger.bun);
    }

    @Test
    public void testAddIngredient() {
        when(mockIngredient1.getName()).thenReturn("Lettuce");
        when(mockIngredient1.getPrice()).thenReturn(0.50f);

        burger.addIngredient(mockIngredient1);

        assertEquals("Wrong ingredient count", 1, burger.ingredients.size());
        assertEquals("Wrong ingredient", mockIngredient1, burger.ingredients.get(0));
    }

    @Test
    public void testRemoveIngredient() {
        when(mockIngredient1.getName()).thenReturn("Lettuce");
        when(mockIngredient1.getPrice()).thenReturn(0.50f);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        burger.removeIngredient(0);

        assertEquals("Wrong ingredient count", 1, burger.ingredients.size());
        assertEquals("Wrong ingredient remove", mockIngredient2, burger.ingredients.get(0));
    }

    @Test
    public void testMoveIngredient() {
        when(mockIngredient1.getName()).thenReturn("Lettuce");
        when(mockIngredient1.getPrice()).thenReturn(0.50f);
        when(mockIngredient2.getName()).thenReturn("Tomato");
        when(mockIngredient2.getPrice()).thenReturn(0.75f);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        burger.moveIngredient(0, 1);

        assertEquals("Wrong ingredient change", mockIngredient2, burger.ingredients.get(0));
        assertEquals("Wrong ingredient change", mockIngredient1, burger.ingredients.get(1));
    }

    @Test
    public void testGetPrice() {
        when(mockBun.getPrice()).thenReturn(1.99f);
        when(mockIngredient1.getPrice()).thenReturn(0.50f);
        when(mockIngredient2.getPrice()).thenReturn(0.75f);
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        float price = burger.getPrice();

        assertEquals("Wrong price", 1.99f * 2 + 0.50f + 0.75f, price, 0.001);
    }

    @Test
    public void testGetReceipt() {

        when(mockBun.getName()).thenReturn("Sesame Bun");
        when(mockIngredient1.getName()).thenReturn("Lettuce");
        when(mockIngredient1.getType()).thenReturn(IngredientType.FILLING);
        when(mockIngredient2.getName()).thenReturn("Ketchup");
        when(mockIngredient2.getType()).thenReturn(IngredientType.SAUCE);
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        String receipt = burger.getReceipt();

        StringBuilder expectedReceipt = new StringBuilder(String.format("(==== %s ====)%n", mockBun.getName()));

        expectedReceipt.append(String.format("= %s %s =%n", mockIngredient1.getType().toString().toLowerCase(), mockIngredient1.getName()));
        expectedReceipt.append(String.format("= %s %s =%n", mockIngredient2.getType().toString().toLowerCase(), mockIngredient2.getName()));
        expectedReceipt.append(String.format("(==== %s ====)%n", mockBun.getName()));
        expectedReceipt.append(String.format("%nPrice: %f%n", burger.getPrice()));

        assertEquals("Wrong receipt", expectedReceipt.toString(), burger.getReceipt());
    }
}