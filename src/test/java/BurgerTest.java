import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class BurgerTest {
    private AutoCloseable closeable;

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient;

    @Mock
    private Ingredient oneMoreIngredient;

    @Spy
    private Burger burger;

    @Before
    public void setupTest() {
        closeable = MockitoAnnotations.openMocks(this);
        when(bun.getName()).thenReturn("Флюоресцентная булка");
        when(bun.getPrice()).thenReturn(988.0f);
        when(ingredient.getPrice()).thenReturn(90.0f);
        when(ingredient.getName()).thenReturn("spicy sauce");
        when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        when(oneMoreIngredient.getPrice()).thenReturn(80.0f);
        when(oneMoreIngredient.getName()).thenReturn("cutlet");
        when(oneMoreIngredient.getType()).thenReturn(IngredientType.FILLING);
    }

    @Test
    public void addIngredientAdded() {
        burger.addIngredient(ingredient);
        assertNotNull(burger.ingredients.get(0));
    }

    @Test
    public void removeIngredientRemoved() {
        burger.ingredients.add(ingredient);
        burger.removeIngredient(0);
        assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientMoved() {
        burger.ingredients.addAll(List.of(ingredient, oneMoreIngredient));
        burger.moveIngredient(0, 1);
        Ingredient actual = burger.ingredients.get(1);
        assertEquals("Incorrect movement of an ingredient", ingredient, actual);
    }

    @Test
    public void getReturnedPriceOfTheBurger() {
        burger.setBuns(bun);
        burger.ingredients.addAll(List.of(ingredient, oneMoreIngredient));
        assertEquals(2146.0, burger.getPrice(), 0.01);
    }

    @Test
    public void getCorrectReceiptReceived() {
        burger.setBuns(bun);
        burger.ingredients.addAll(List.of(ingredient, oneMoreIngredient));
        String expected = "(==== Флюоресцентная булка ====)\n" +
                "= sauce spicy sauce =\n" +
                "= filling cutlet =\n" +
                "(==== Флюоресцентная булка ====)\n" +
                "\nPrice: 2146,000000\n";
        assertEquals(expected, burger.getReceipt());
    }

    @After
    public void teardownTest() throws Exception {
        closeable.close();
    }
}
