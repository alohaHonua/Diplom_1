package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

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
        when(mockBun.getName()).thenReturn("Black Bun");
        when(mockBun.getPrice()).thenReturn(100f);
        when(mockIngredient1.getPrice()).thenReturn(50f);
        when(mockIngredient2.getPrice()).thenReturn(200f);
    }

    @Test
    public void testSetBuns() {
        burger.setBuns(mockBun);
        assertSame(mockBun, burger.bun);
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(mockIngredient1);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(mockIngredient1);
        burger.removeIngredient(0);
        assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void testMoveIngredient() {
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        burger.moveIngredient(0, 1);
        assertEquals(mockIngredient2, burger.ingredients.get(0));
    }

    @Test
    public void testGetPrice() {
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        float expected = 100 * 2 + 50 + 200;
        assertEquals(expected, burger.getPrice(), 0.001);
    }

    @Test
    public void testGetReceipt() {
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        when(mockIngredient1.getType()).thenReturn(IngredientType.SAUCE);
        when(mockIngredient1.getName()).thenReturn("Spicy Sauce");

        String lineSeparator = System.lineSeparator();

        // Формируем ожидаемую строку с учетом локали
        String expectedPrice = String.format("%nPrice: 250.000000%n")
                .replace('.', ','); // Заменяем точку на запятую, если нужно

        String expected = "(==== Black Bun ====)" + lineSeparator
                + "= sauce Spicy Sauce =" + lineSeparator
                + "(==== Black Bun ====)" + lineSeparator
                + lineSeparator
                + "Price: 250.000000" + lineSeparator;

        // Сравниваем без учёта разделителя (или заменяем его)
        String actual = burger.getReceipt().replace(',', '.'); // Унифицируем разделитель
        assertEquals(expected.replace(',', '.'), actual);
    }
}