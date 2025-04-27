package unit;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
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
        burger = new Burger();
    }

    @Test
    public void setBunsShouldSetTheBun() {
        burger.setBuns(mockBun);
        assertSame("The bun must be set", mockBun, burger.bun);
    }

    @Test
    public void addIngredientShouldAddToList() {
        burger.addIngredient(mockIngredient1);
        assertEquals("The size of the ingredient list should be 1", 1, burger.ingredients.size());
        assertSame("The added ingredient must be in the list", mockIngredient1, burger.ingredients.get(0));

        burger.addIngredient(mockIngredient2);
        assertEquals("The size of the ingredient list should be 2", 2, burger.ingredients.size());
        assertSame("The second added ingredient must be in the list", mockIngredient2, burger.ingredients.get(1));
    }

    @Test
    public void removeIngredientShouldRemoveFromList() {
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        burger.removeIngredient(0);

        assertEquals("The size of the list should be reduced to 1", 1, burger.ingredients.size());
        assertSame("The second ingredient should remain in the list", mockIngredient2, burger.ingredients.get(0));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeIngredientWithInvalidIndexShouldThrowException() {
        burger.addIngredient(mockIngredient1);
        burger.removeIngredient(1);
    }

    @Test
    public void moveIngredientShouldChangeOrder() {
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        burger.moveIngredient(0, 1);

        assertEquals("The size of the list should not change", 2, burger.ingredients.size());
        assertSame("The first element should become mockIngredient2", mockIngredient2, burger.ingredients.get(0));
        assertSame("The second element should become mockIngredient1", mockIngredient1, burger.ingredients.get(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void moveIngredientWithInvalidIndexShouldThrowException() {
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        burger.moveIngredient(0, 5);
    }

    @Test
    public void getPriceShouldCalculateCorrectly() {
        when(mockBun.getPrice()).thenReturn(100.0f);
        when(mockIngredient1.getPrice()).thenReturn(50.5f);
        when(mockIngredient2.getPrice()).thenReturn(75.0f);

        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        float expectedPrice = 325.5f;
        assertEquals("The price must be calculated correctly", expectedPrice, burger.getPrice(), 0.0f);

        Mockito.verify(mockBun, Mockito.times(1)).getPrice();
        Mockito.verify(mockIngredient1, Mockito.times(1)).getPrice();
        Mockito.verify(mockIngredient2, Mockito.times(1)).getPrice();
    }

    @Test
    public void getPriceWithOnlyBunShouldCalculateCorrectly() {
        when(mockBun.getPrice()).thenReturn(150f);
        burger.setBuns(mockBun);
        assertEquals("Price with only the bun", 300.0f, burger.getPrice(), 0.0f);
    }

    @Test
    public void getReceiptShouldFormatCorrectly() {
        when(mockBun.getName()).thenReturn("Krator Bun");
        when(mockBun.getPrice()).thenReturn(125.0f);

        when(mockIngredient1.getType()).thenReturn(IngredientType.SAUCE);
        when(mockIngredient1.getName()).thenReturn("Spicy Sauce");
        when(mockIngredient1.getPrice()).thenReturn(50.0f);

        when(mockIngredient2.getType()).thenReturn(IngredientType.FILLING);
        when(mockIngredient2.getName()).thenReturn("Asteroid Cutlet");
        when(mockIngredient2.getPrice()).thenReturn(200.0f);

        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        String expectedReceipt = String.format("(==== Krator Bun ====)%n");
        expectedReceipt += String.format("= sauce Spicy Sauce =%n");
        expectedReceipt += String.format("= filling Asteroid Cutlet =%n");
        expectedReceipt += String.format("(==== Krator Bun ====)%n");
        expectedReceipt += String.format("%nPrice: %f%n", 500.0f);

        assertEquals("The receipt format must match the expected", expectedReceipt, burger.getReceipt());
    }

    @Test
    public void getReceiptWithoutIngredients() {
        when(mockBun.getName()).thenReturn("Empty Bun");
        when(mockBun.getPrice()).thenReturn(50f);
        burger.setBuns(mockBun);

        String expectedReceipt = String.format("(==== Empty Bun ====)%n");
        expectedReceipt += String.format("(==== Empty Bun ====)%n");
        expectedReceipt += String.format("%nPrice: %f%n", 100.0f);

        assertEquals("Receipt format without ingredients", expectedReceipt, burger.getReceipt());
    }
}
