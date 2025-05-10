package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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
        MockitoAnnotations.openMocks(this);
        burger = new Burger();
    }

    @Test
    public void setBunsShouldSetCorrectBun() {
        burger.setBuns(mockBun);
        assertEquals(mockBun, burger.bun);
    }

    @Test
    public void addIngredientShouldIncreaseListSize() {
        burger.addIngredient(mockIngredient1);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientShouldDecreaseListSize() {
        burger.addIngredient(mockIngredient1);
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientShouldChangeOrder() {
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        burger.moveIngredient(0, 1);
        assertEquals(mockIngredient2, burger.ingredients.get(0));
    }

    @Test
    public void getPriceShouldReturnCorrectValue() {
        when(mockBun.getPrice()).thenReturn(100f);
        when(mockIngredient1.getPrice()).thenReturn(50f);
        when(mockIngredient2.getPrice()).thenReturn(30f);

        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        assertEquals(100*2 + 50 + 30, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptShouldContainAllParts() {
        when(mockBun.getName()).thenReturn("White Bun");
        when(mockBun.getPrice()).thenReturn(100f);

        when(mockIngredient1.getType()).thenReturn(IngredientType.SAUCE);
        when(mockIngredient1.getName()).thenReturn("Ketchup");
        when(mockIngredient1.getPrice()).thenReturn(30f);

        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);

        String receipt = burger.getReceipt();

        assertTrue(receipt.contains("White Bun"));
        assertTrue(receipt.toLowerCase().contains("ketchup"));
        assertTrue(receipt.contains("Price: "));
    }
}