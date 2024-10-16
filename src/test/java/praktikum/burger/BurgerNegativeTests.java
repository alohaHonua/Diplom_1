package praktikum.burger;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import praktikum.Burger;
import praktikum.Bun;
import praktikum.Ingredient;
import praktikum.TestConstants;

import static org.junit.Assert.assertThrows;

public class BurgerNegativeTests {

    private Burger burger;
    private Bun mockBun;
    private Ingredient mockIngredient1;
    private Ingredient mockIngredient2;

    @Before
    public void setUp() {
        burger = new Burger();
        mockBun = Mockito.mock(Bun.class);
        mockIngredient1 = Mockito.mock(Ingredient.class);
    }

    // Попытка рассчитать цену без булочки должна вызывать NullPointerException
    @Test
    public void testGetPriceWithoutBun() {
        // Проверка, что метод getPrice выбрасывает NullPointerException
        assertThrows(NullPointerException.class, () -> burger.getPrice());
    }

    // Попытка получить чек без булочки должна вызывать NullPointerException
    @Test
    public void testGetReceiptWithoutBun() {
        // Проверка, что метод getReceipt выбрасывает NullPointerException
        assertThrows(NullPointerException.class, () -> burger.getReceipt());
    }


    // Попытка удалить ингредиент по некорректному индексу должна вызывать IndexOutOfBoundsException
    @Test
    public void testRemoveIngredientInvalidIndex() {
        // Проверка, что метод removeIngredient выбрасывает IndexOutOfBoundsException
        assertThrows(IndexOutOfBoundsException.class, () -> burger.removeIngredient(TestConstants.INVALID_INDEX));
    }

    // Перемещение ингредиента на недопустимый индекс
    @Test
    public void testMoveIngredientToInvalidIndex() {
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        // Проверка выброса исключения при некорректном индексе
        assertThrows(IndexOutOfBoundsException.class, () -> burger.moveIngredient(TestConstants.FIRST_INDEX, TestConstants.INVALID_INDEX));
    }

    // Удаление ингредиента из пустого списка должно выбросить исключение
    @Test
    public void testRemoveIngredientFromEmptyList() {
        // Проверка, что метод removeIngredient выбрасывает IndexOutOfBoundsException при удалении из пустого списка
        assertThrows(IndexOutOfBoundsException.class, () -> burger.removeIngredient(TestConstants.FIRST_INDEX));
    }


}
