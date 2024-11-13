package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

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
        MockitoAnnotations.initMocks(this);
        burger = new Burger();
    }

    @Test
    public void testSetBuns() {
        when(mockBun.getName()).thenReturn("Sesame Bun");
        when(mockBun.getPrice()).thenReturn(1.5f);

        burger.setBuns(mockBun);

        assertEquals("Sesame Bun", burger.bun.getName());
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(mockSauce);

        List<Ingredient> ingredients = burger.ingredients;

        assertTrue("Ingredients list should contain added ingredient", ingredients.contains(mockSauce));
    }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(mockSauce);
        burger.removeIngredient(0);

        List<Ingredient> ingredients = burger.ingredients;

        assertTrue("Ingredients list should be empty after removing ingredient", ingredients.isEmpty());
    }

    @Test
    public void testMoveIngredient() {
        burger.addIngredient(mockSauce);
        burger.addIngredient(mockFilling);

        burger.moveIngredient(0, 1);

        List<Ingredient> ingredients = burger.ingredients;

        assertEquals("First ingredient should be mockFilling after move", mockFilling, ingredients.get(0));
        assertEquals("Second ingredient should be mockSauce after move", mockSauce, ingredients.get(1));
    }

    @Test
    public void testGetPrice() {
        when(mockBun.getPrice()).thenReturn(2.0f);
        when(mockSauce.getPrice()).thenReturn(0.5f);
        when(mockFilling.getPrice()).thenReturn(1.0f);

        burger.setBuns(mockBun);
        burger.addIngredient(mockSauce);
        burger.addIngredient(mockFilling);

        float expectedPrice = 2.0f * 2 + 0.5f + 1.0f;
        assertEquals("Burger price should be calculated correctly", expectedPrice, burger.getPrice(), 0.0f);
    }

    @Test
    public void testGetReceipt() {
        when(mockBun.getName()).thenReturn("Sesame Bun");
        when(mockSauce.getName()).thenReturn("Spicy Sauce");
        when(mockSauce.getType()).thenReturn(IngredientType.SAUCE);
        when(mockFilling.getName()).thenReturn("Chicken");
        when(mockFilling.getType()).thenReturn(IngredientType.FILLING);
        when(mockBun.getPrice()).thenReturn(2.0f);
        when(mockSauce.getPrice()).thenReturn(0.5f);
        when(mockFilling.getPrice()).thenReturn(1.0f);

        burger.setBuns(mockBun);
        burger.addIngredient(mockSauce);
        burger.addIngredient(mockFilling);

        String expectedReceipt = "(==== Sesame Bun ====)\n" +
                "= sauce Spicy Sauce =\n" +
                "= filling Chicken =\n" +
                "(==== Sesame Bun ====)\n" +
                "\nPrice: 5,500000\n";

        // Приводим обе строки к единому виду, заменяя все разрывы строк на \n
        assertEquals("Burger receipt should match expected format",
                expectedReceipt.replaceAll("\\r?\\n", "\n"),
                burger.getReceipt().replaceAll("\\r?\\n", "\n"));
    }



}
