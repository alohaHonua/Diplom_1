package praktikum.burger;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class BurgerGetReceiptTest {

    private Burger burger;
    private Bun mockBun;
    private Ingredient mockIngredient;

    @Before
    public void setUp() {
        burger = new Burger();
        mockBun = Mockito.mock(Bun.class);
        mockIngredient = Mockito.mock(Ingredient.class);

        // Настраиваем моки
        Mockito.when(mockBun.getName()).thenReturn("black bun");
        Mockito.when(mockBun.getPrice()).thenReturn(100f);
        Mockito.when(mockIngredient.getName()).thenReturn("cutlet");
        Mockito.when(mockIngredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(mockIngredient.getPrice()).thenReturn(200f);

        // Собираем бургер
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient);
    }

    @Test
    public void testGetReceipt() {
        String expectedReceipt = "(==== black bun ====)\n" +
                "= filling cutlet =\n" +
                "(==== black bun ====)\n" +
                "\nPrice: 400.00\n";  // Ожидаемая строка с двумя знаками после запятой

        // Получаем реальный результат
        String actualReceipt = burger.getReceipt();
        System.out.println("Actual receipt:\n" + actualReceipt);

        // Проверяем корректность рецепта
        assertEquals(expectedReceipt, actualReceipt);
    }
}