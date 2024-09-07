import praktikum.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
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
        when(bun.getName()).thenReturn("Супер мега космическая булочка");
        when(bun.getPrice()).thenReturn(3.15f);
        when(ingredient.getPrice()).thenReturn(10.15f);
        when(ingredient.getName()).thenReturn("Мясо Protostomia");
        when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        when(oneMoreIngredient.getPrice()).thenReturn(3.15f);
        when(oneMoreIngredient.getName()).thenReturn("Соус фирменный Space Sauce");
        when(oneMoreIngredient.getType()).thenReturn(IngredientType.SAUCE);
    }
    @After
    public void teardownTest() throws Exception {
        closeable.close();
    }
    @Test
    public void setBunsCallSetBunsIsCalled() {
        burger.setBuns(bun);
        Mockito.verify(burger, Mockito.times(1)).setBuns(bun);
        assertNotNull(burger.bun);
    }
    @Test
    public void addIngredientIngredientAdded() {
        burger.addIngredient(ingredient);
        assertNotNull(burger.ingredients.get(0));
    }
    @Test
    public void removeIngredientIngredientRemoved() {
        burger.ingredients.add(ingredient);
        burger.removeIngredient(0);
        assertTrue(burger.ingredients.isEmpty());
    }
    @Test
    public void moveIngredientIngredientMoved() {
        burger.ingredients.addAll(List.of(ingredient, oneMoreIngredient));
        burger.moveIngredient(1, 0);
        burger.ingredients.get(1).getName();
        Mockito.verify(ingredient).getName();
    }
    @Test
    public void getPriceReturnedPriceOfTheBurger() {
        burger.setBuns(bun);
        burger.ingredients.addAll(List.of(ingredient, oneMoreIngredient));
        assertEquals(19.6, burger.getPrice(), 0.01);
    }
    @Test
    public void getReceiptCorrectReceiptReceived() {
        burger.setBuns(bun);
        burger.ingredients.addAll(List.of(ingredient, oneMoreIngredient));
        String expected = "(==== Супер мега космическая булочка ====)\n" +
                "= filling Мясо Protostomia =\n" +
                "= sauce Соус фирменный Space Sauce =\n" +
                "(==== Супер мега космическая булочка ====)\n" +
                "\nPrice: 19,600000\n";
        assertEquals(expected, burger.getReceipt());
    }
}