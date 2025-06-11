package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BurgerTest {
    private Burger burger;
    private Bun bun;
    private Ingredient sauce;
    private Ingredient filling;

    @Before
    public void setUp() {
        burger = new Burger();

        bun = mock(Bun.class);
        when(bun.getName()).thenReturn("Мок-булка");
        when(bun.getPrice()).thenReturn(500f);

        sauce = mock(Ingredient.class);
        when(sauce.getName()).thenReturn("Мок-соус");
        when(sauce.getPrice()).thenReturn(100f);
        when(sauce.getType()).thenReturn(IngredientType.SAUCE);

        filling = mock(Ingredient.class);
        when(filling.getName()).thenReturn("Мок-начинка");
        when(filling.getPrice()).thenReturn(300f);
        when(filling.getType()).thenReturn(IngredientType.FILLING);

        burger.setBuns(bun);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
    }

    @Test
    public void setBunsSetsBunCorrectly() {
        assertEquals("Мок-булка", burger.bun.getName());
        assertEquals(500f, burger.bun.getPrice(), 0.01);
    }

    @Test
    public void addIngredientAddsIngredientToList() {
        assertEquals(2, burger.ingredients.size());
        assertEquals("Мок-соус", burger.ingredients.get(0).getName());
        assertEquals("Мок-начинка", burger.ingredients.get(1).getName());
    }

    @Test
    public void removeIngredientRemovesByIndex() {
        burger.removeIngredient(0);
        assertEquals(1, burger.ingredients.size());
        assertEquals("Мок-начинка", burger.ingredients.get(0).getName());
    }

    @Test
    public void moveIngredientMovesIngredient() {
        Ingredient extra = mock(Ingredient.class);
        when(extra.getName()).thenReturn("Мок-доп");
        when(extra.getPrice()).thenReturn(50f);
        when(extra.getType()).thenReturn(IngredientType.SAUCE);

        burger.addIngredient(extra);
        burger.moveIngredient(2, 0);

        assertEquals("Мок-доп", burger.ingredients.get(0).getName());
        assertEquals("Мок-соус", burger.ingredients.get(1).getName());
        assertEquals("Мок-начинка", burger.ingredients.get(2).getName());
    }

    @Test
    public void getPriceReturnsSumOfBunsAndIngredients() {
        float expectedPrice = 500 * 2 + 100 + 300;
        assertEquals(expectedPrice, burger.getPrice(), 0.01);
    }

    @Test
    public void getReceiptReturnsCorrectFormat() {
        String receipt = burger.getReceipt();
        assertTrue(receipt.contains("Мок-булка"));
        assertTrue(receipt.contains("мок-соус"));
        assertTrue(receipt.contains("мок-начинка"));
        assertTrue(receipt.contains("1400.0"));
        assertTrue(receipt.contains("Price"));
    }
}