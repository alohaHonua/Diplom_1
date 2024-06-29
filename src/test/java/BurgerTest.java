import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;


import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BurgerTest {
    private Burger burger;

    @Mock
    private Bun mockBun;

    @Mock
    private Ingredient mockIngredient1;

    @Mock
    private Ingredient mockIngredient2;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        burger = new Burger();
        when(mockBun.getName()).thenReturn("Classic Bun");
        when(mockBun.getPrice()).thenReturn(5.5f);
        when(mockIngredient1.getName()).thenReturn("Lettuce");
        when(mockIngredient1.getPrice()).thenReturn(1.0f);
        when(mockIngredient1.getType()).thenReturn(IngredientType.FILLING);
        when(mockIngredient2.getName()).thenReturn("Mayo");
        when(mockIngredient2.getPrice()).thenReturn(0.5f);
        when(mockIngredient2.getType()).thenReturn(IngredientType.SAUCE);
    }

    @Test
    public void testSetBuns() {
        burger.setBuns(mockBun);
        assertEquals(mockBun, burger.bun);
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(mockIngredient1);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(mockIngredient1);
        burger.removeIngredient(0);
        assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void testMoveIngredient() {
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        burger.moveIngredient(0, 1);
        assertEquals(mockIngredient2, burger.ingredients.get(0));
    }

    @Test
    public void testGetPrice() {
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        assertEquals(12.5f, burger.getPrice(), 0.01);
    }

    @Test
    public void testGetReceipt() {
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        String receipt = burger.getReceipt();
        receipt = receipt.replace(",", "."); // Замена запятой на точку для числовых значений

        String expectedReceipt = "(==== Classic Bun ====)\n" +
                "= filling Lettuce =\n" +
                "= sauce Mayo =\n" +
                "(==== Classic Bun ====)\n" +
                "\nPrice: 12.500000\n";

        assertEquals(expectedReceipt, receipt);
    }
}