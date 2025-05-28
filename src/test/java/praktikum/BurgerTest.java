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
        assertSame("Булка должна быть установлена", mockBun, burger.bun);
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(mockIngredient1);
        assertEquals("Должен быть добавлен 1 ингредиент",1, burger.ingredients.size());
    }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(mockIngredient1);
        burger.removeIngredient(0);
        assertTrue("Список ингредиентов должен быть пустым", burger.ingredients.isEmpty());
    }

    @Test
    public void testMoveIngredient() {
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        burger.moveIngredient(0, 1);
        assertEquals("Ингредиенты должны поменяться местами", mockIngredient2, burger.ingredients.get(0));
    }

    @Test
    public void testGetPrice() {
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        float expected = 100 * 2 + 50 + 200;
        assertEquals("Цена должна корректно рассчитываться", expected, burger.getPrice(), 0.001);
    }

    @Test
    public void testGetReceiptBunName() { // прошлый метод testGetReceipt разделил на три
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        when(mockIngredient1.getType()).thenReturn(IngredientType.SAUCE);
        when(mockIngredient1.getName()).thenReturn("Spicy Sauce");

        String receipt = burger.getReceipt();
        assertTrue("Должно содержать название булки", receipt.contains("Black Bun"));
    }

    @Test
    public void testGetReceiptIngredient() {
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        when(mockIngredient1.getType()).thenReturn(IngredientType.SAUCE);
        when(mockIngredient1.getName()).thenReturn("Spicy Sauce");

        String receipt = burger.getReceipt();
        assertTrue("Должно содержать ингредиент", receipt.contains("Spicy Sauce"));
    }

    @Test
    public void testGetReceiptPriceFormat() {
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        when(mockIngredient1.getType()).thenReturn(IngredientType.SAUCE);
        when(mockIngredient1.getName()).thenReturn("Spicy Sauce");

        String receipt = burger.getReceipt();
        assertTrue("Должно содержать корректный формат цены",
                receipt.contains("250.000000") || receipt.contains("250,000000"));
    }
}