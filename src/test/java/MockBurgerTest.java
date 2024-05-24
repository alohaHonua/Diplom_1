import org.junit.Before;
import org.junit.Test;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
public class MockBurgerTest {
    private Burger burger;
    private Ingredient sauce;
    private Ingredient filling;

    @Before
    public void setUp() {
        burger = mock(Burger.class);
        sauce = new Ingredient(IngredientType.SAUCE, "ketchup", 100);
        filling = new Ingredient(IngredientType.FILLING, "beef", 200);
    }

    @Test
    public void testAddIngredientCalledThreeTimes() {
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        burger.addIngredient(sauce);
        verify(burger, times(3)).addIngredient(any(Ingredient.class));
    }

    @Test
    public void testGetPriceReturns700() {
        when(burger.getPrice()).thenReturn(700f);
        assertEquals(700f, burger.getPrice(), 0);
    }
}
