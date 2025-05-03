package praktikum;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BurgerTest {

    private Burger burger;
    private Bun bunMock;
    private Ingredient filling;
    private Ingredient sauce;

    @Before
    public void setUp() {
        burger = new Burger();
        bunMock = mock(Bun.class);
        when(bunMock.getPrice()).thenReturn(3f);
        when(bunMock.getName()).thenReturn("СуперБулка");
        burger.setBuns(bunMock);

        filling = mock(Ingredient.class);
        when(filling.getPrice()).thenReturn(2f);
        when(filling.getType()).thenReturn(IngredientType.FILLING);
        when(filling.getName()).thenReturn("Жучки");

        sauce = mock(Ingredient.class);
        when(sauce.getPrice()).thenReturn(1f);
        when(sauce.getType()).thenReturn(IngredientType.SAUCE);
        when(sauce.getName()).thenReturn("Кетчуп");
    }

    @Test
    public void setBunsValidBunTest() {
        assertSame(bunMock, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(filling);
        assertTrue(burger.ingredients.contains(filling));
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(filling);
        burger.addIngredient(sauce);
        burger.removeIngredient(0);
        assertFalse(burger.ingredients.contains(filling));
        assertEquals(1,burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(filling);
        burger.addIngredient(sauce);
        burger.moveIngredient(0,1);
        List<Ingredient> list = burger.ingredients;
        assertEquals(sauce, list.get(0));
        assertEquals(filling, list.get(1));
    }

    @Test
    public void getPriceCorrectPriceTest() {
        burger.addIngredient(filling);
        burger.addIngredient(sauce);
        assertEquals(9f, burger.getPrice(), 0.001f);
    }

    @Test
    public void getReceiptReturnFormattedReceipt() {
        burger.addIngredient(filling);
        burger.addIngredient(sauce);
        String receipt = burger.getReceipt();
        String expected = String.format("(==== %s ====)%n", bunMock.getName()) +
                          String.format("= %s %s =%n", filling.getType().toString().toLowerCase(), filling.getName()) +
                          String.format("= %s %s =%n", sauce.getType().toString().toLowerCase(), sauce.getName()) +
                          String.format("(==== %s ====)%n", bunMock.getName()) +
                          String.format("%nPrice: %f%n", burger.getPrice());
        assertEquals(expected, receipt);
    }
}
