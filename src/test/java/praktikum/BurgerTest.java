package praktikum;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BurgerTest {

    private Bun mockBun;
    private Ingredient mockIngredient;
    private Ingredient mockIngredient2;
    private Burger burger;

    @Before
    public void setUp() {
        // Создаем мок-объекты для булочки и ингредиентов
        mockBun = mock(Bun.class);
        mockIngredient = mock(Ingredient.class);
        mockIngredient2 = mock(Ingredient.class);
        burger = new Burger();
    }

    @Test
    public void testSetBuns() {
        burger.setBuns(mockBun);  // Устанавливаем булочку
        assertEquals("Булочка должна быть установлена корректно", mockBun, burger.bun);
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(mockIngredient);
        assertEquals("После добавления ингредиента размер списка должен быть 1", 1, burger.ingredients.size());
    }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(mockIngredient);
        burger.removeIngredient(0);
        assertEquals("После удаления ингредиента список должен стать пустым", 0, burger.ingredients.size());
    }

    @Test
    public void testMoveIngredient() {
        burger.addIngredient(mockIngredient);
        burger.addIngredient(mockIngredient2);
        burger.moveIngredient(0, 1);

        assertEquals("Первый ингредиент должен переместиться на вторую позицию", mockIngredient2, burger.ingredients.get(0));
        assertEquals("Второй ингредиент должен переместиться на первую позицию", mockIngredient, burger.ingredients.get(1));
    }

    @Test
    public void testGetPrice() {
        when(mockBun.getPrice()).thenReturn(100f);
        when(mockIngredient.getPrice()).thenReturn(50f);

        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient);

        assertEquals("Цена бургера должна быть (цена булочки * 2 + цена ингредиента)", 250.0, burger.getPrice(), 0.01);
    }

    @Test
    public void testGetReceipt() {
        when(mockBun.getName()).thenReturn("black bun");
        when(mockBun.getPrice()).thenReturn(100f);
        when(mockIngredient.getName()).thenReturn("cutlet");
        when(mockIngredient.getType()).thenReturn(IngredientType.FILLING);
        when(mockIngredient.getPrice()).thenReturn(50f);

        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient);

        String expectedReceipt = "(==== black bun ====)\n= filling cutlet =\n(==== black bun ====)\n\nPrice: 250.000000\n";
        String actualReceipt = burger.getReceipt();

        String normalizedExpected = expectedReceipt.replace("\r\n", "\n");
        String normalizedActual = actualReceipt.replace("\r\n", "\n");

        assertEquals("Чек должен соответствовать ожидаемому значению", normalizedExpected, normalizedActual);
    }
}
