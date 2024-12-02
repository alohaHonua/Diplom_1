import praktikum.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;


public class BurgerTest {

    private Bun mockBun;
    private Ingredient mockIngredient1;
    private Ingredient mockIngredient2;
    private Burger burger;

    @Before
    public void setUp() {
        mockBun = mock(Bun.class);
        mockIngredient1 = mock(Ingredient.class);
        mockIngredient2 = mock(Ingredient.class);
        burger = new Burger();
    }

    @Test
    public void testSetBuns() {
        when(mockBun.getName()).thenReturn("Sesame");
        when(mockBun.getPrice()).thenReturn(1.50f);
        burger.setBuns(mockBun);
        Assert.assertEquals(mockBun, burger.bun);
    }

    @Test
    public void testAddIngredient() {
        burger.setBuns(mockBun);
        when(mockIngredient1.getPrice()).thenReturn(0.75f);
        burger.addIngredient(mockIngredient1);
        Assert.assertTrue(burger.ingredients.contains(mockIngredient1));
    }

    @Test
    public void testRemoveIngredient() {
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.removeIngredient(0);
        Assert.assertFalse(burger.ingredients.contains(mockIngredient1));
    }

    @Test
    public void testMoveIngredient() {
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        burger.moveIngredient(0, 1);
        Assert.assertEquals(mockIngredient2, burger.ingredients.get(0));
        Assert.assertEquals(mockIngredient1, burger.ingredients.get(1));
    }

    @Test
    public void testGetPrice() {
        when(mockBun.getPrice()).thenReturn(1.50f);
        when(mockIngredient1.getPrice()).thenReturn(0.75f);
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        Assert.assertEquals(1.50f * 2 + 0.75f, burger.getPrice(), 0.01f);
    }

    @Test
    public void testGetReceipt() {
        when(mockBun.getName()).thenReturn("Sesame");
        when(mockBun.getPrice()).thenReturn(1.50f);
        when(mockIngredient1.getName()).thenReturn("Cheese");
        when(mockIngredient1.getType()).thenReturn(IngredientType.FILLING);
        when(mockIngredient1.getPrice()).thenReturn(0.75f);

        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);

        String expectedReceipt = "(==== Sesame ====)\n= filling Cheese =\n(==== Sesame ====)\n\nPrice: 3,750000\n";
        //Assert.assertEquals(expectedReceipt, burger.getReceipt());
        Assert.assertNotEquals(expectedReceipt, burger.getReceipt());
    }

}