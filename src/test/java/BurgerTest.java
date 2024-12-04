import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import praktikum.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class BurgerTest {

    @Mock
    private Bun mockBun;
    private Ingredient mockIngredient1;
    private Ingredient mockIngredient2;
    private Burger burger;

    @Before
    public void setUp() {
        mockBun = Mockito.mock(Bun.class);
        mockIngredient1 = Mockito.mock(Ingredient.class);
        mockIngredient2 = Mockito.mock(Ingredient.class);
        burger = new Burger();

        when(mockBun.getName()).thenReturn("Mock Bun");
        when(mockBun.getPrice()).thenReturn(100f);

        when(mockIngredient1.getName()).thenReturn("Mock Ingredient 1");
        when(mockIngredient1.getType()).thenReturn(IngredientType.SAUCE);
        when(mockIngredient1.getPrice()).thenReturn(50f);

        when(mockIngredient2.getName()).thenReturn("Mock Ingredient 2");
        when(mockIngredient2.getType()).thenReturn(IngredientType.FILLING);
        when(mockIngredient2.getPrice()).thenReturn(70f);
    }

    @Test
    public void testSetBuns() {
        burger.setBuns(mockBun);
        assertEquals("Mock Bun", burger.bun.getName());
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(mockIngredient1);
        assertEquals(1, burger.ingredients.size());
        assertEquals("Mock Ingredient 1", burger.ingredients.get(0).getName());
    }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        burger.removeIngredient(0);
        assertEquals(1, burger.ingredients.size());
        assertEquals("Mock Ingredient 2", burger.ingredients.get(0).getName());
    }

    @Test
    public void testMoveIngredient() {
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        burger.moveIngredient(1, 0);
        assertEquals("Mock Ingredient 2", burger.ingredients.get(0).getName());
    }

    @Test
    public void testGetPrice() {
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        float price = burger.getPrice();
        assertEquals(320f, price, 0.01);
    }

    @Test
    public void testGetReceipt() {
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        String expectedReceipt = String.format(
                "(==== Mock Bun ====)%n" +
                        "= sauce Mock Ingredient 1 =%n" +
                        "= filling Mock Ingredient 2 =%n" +
                        "(==== Mock Bun ====)%n%n" +
                        "Price: 320,000000%n");

        assertEquals(expectedReceipt, burger.getReceipt());
    }
}



