package praktikum.burger;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import praktikum.Burger;
import praktikum.Bun;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class BurgerNegativeTests {

    private Burger burger;
    private Bun mockBun;
    private Ingredient mockIngredient;

    @Before
    public void setUp() {
        burger = new Burger();
        mockBun = Mockito.mock(Bun.class);
        mockIngredient = Mockito.mock(Ingredient.class);
    }

    // Тест: попытка рассчитать цену без булочки должна вызывать NullPointerException
    @Test(expected = NullPointerException.class)
    public void testGetPriceWithoutBun() {
        // Попытка расчета цены без установки булочки
        burger.getPrice();
    }

    // Тест: попытка получить чек без булочки должна вызывать NullPointerException
    @Test(expected = NullPointerException.class)
    public void testGetReceiptWithoutBun() {
        // Попытка получить чек без установки булочки
        burger.getReceipt();
    }

    // Тест: попытка удалить ингредиент по некорректному индексу должна вызывать IndexOutOfBoundsException
    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveIngredientInvalidIndex() {
        // Попытка удалить ингредиент по недопустимому индексу
        burger.removeIngredient(5);  // В списке ингредиентов ничего нет
    }

    // Тест: попытка переместить ингредиент по некорректному индексу должна вызывать IndexOutOfBoundsException
    @Test(expected = IndexOutOfBoundsException.class)
    public void testMoveIngredientInvalidIndex() {
        // Добавляем один ингредиент
        burger.addIngredient(mockIngredient);
        // Попытка переместить ингредиент с неправильным индексом
        burger.moveIngredient(2, 0);  // В списке только один ингредиент
    }

    // Тест: перемещение ингредиента на недопустимый индекс
    @Test(expected = IndexOutOfBoundsException.class)
    public void testMoveIngredientToInvalidIndex() {
        // Добавляем ингредиенты
        burger.addIngredient(mockIngredient);
        burger.addIngredient(mockIngredient);

        // Попытка переместить ингредиент на недопустимый индекс
        burger.moveIngredient(0, 5);  // В списке два ингредиента
    }

    // Перемещение ингредиента с одинаковым индексом
    @Test
    public void testMoveIngredientSameIndex() {
        // Добавляем один ингредиент
        burger.addIngredient(mockIngredient);

        // Перемещаем ингредиент с индексом 0 на индекс 0 (должно остаться без изменений)
        burger.moveIngredient(0, 0);

        // Проверяем, что ингредиент остался на месте
        assertEquals(mockIngredient, burger.ingredients.get(0));
    }

}
