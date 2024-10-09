import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerUnitTest {
    Burger burger;
    @Mock
    private Bun mockedBun;
    @Mock
    private Ingredient mockedIngredient;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void doesSetBunsReallySetsBuns() {
        burger.setBuns(mockedBun);
        assertEquals(mockedBun, burger.bun);
    }

    @Test
    public void canAddSingleIngredient() {
        burger.addIngredient(mockedIngredient);
        assertEquals(1, burger.ingredients.size());
        assertEquals(mockedIngredient, burger.ingredients.get(0));
    }

    @Test
    public void canAddMultipleIngredients() {
        Ingredient mockedIngredient1 = mock(Ingredient.class);
        Ingredient mockedIngredient2 = mock(Ingredient.class);

        burger.addIngredient(mockedIngredient);
        burger.addIngredient(mockedIngredient1);
        burger.addIngredient(mockedIngredient2);

        assertEquals(3, burger.ingredients.size());
        assertEquals(mockedIngredient, burger.ingredients.get(0));
        assertEquals(mockedIngredient1, burger.ingredients.get(1));
        assertEquals(mockedIngredient2, burger.ingredients.get(2));
    }

    @Test
    public void doesRemoveIngredientsReallyRemovesIngredients() {
        burger.addIngredient(mockedIngredient);
        assertEquals(1, burger.ingredients.size());
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void canMoveIngredients() {
        Ingredient mockedIngredient1 = mock(Ingredient.class);
        burger.addIngredient(mockedIngredient);
        burger.addIngredient(mockedIngredient1);
        burger.moveIngredient(0, 1);
        assertEquals(mockedIngredient1, burger.ingredients.get(0));
        assertEquals(mockedIngredient, burger.ingredients.get(1));
    }

    @Test
    public void doesGetPriceCalculatesPrice() {
        when(mockedBun.getPrice()).thenReturn(5f);
        when(mockedIngredient.getPrice()).thenReturn(7f);
        burger.setBuns(mockedBun);
        burger.addIngredient(mockedIngredient);
        float expectedPrice = 5f * 2 + 7f;
        assertEquals(expectedPrice, burger.getPrice(), 0.001);
    }

    @Test
    public void doesGetReceiptReturnsCorrectString() {
        when(mockedBun.getName()).thenReturn("black bun");
        when(mockedBun.getPrice()).thenReturn(100f);
        when(mockedIngredient.getName()).thenReturn("sausage");
        when(mockedIngredient.getType()).thenReturn(IngredientType.FILLING);
        when(mockedIngredient.getPrice()).thenReturn(300f);

        burger.setBuns(mockedBun);
        burger.addIngredient(mockedIngredient);

        String expectedReceipt = String.format("(==== %s ====)%n", mockedBun.getName()) +
                String.format("= %s %s =%n", "filling", mockedIngredient.getName()) +
                String.format("(==== %s ====)%n", mockedBun.getName()) +
                String.format("%nPrice: %f%n", burger.getPrice());

        assertEquals(expectedReceipt, burger.getReceipt());
    }

}
