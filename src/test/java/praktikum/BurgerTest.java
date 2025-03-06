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
        // Проверяем, что булочка была правильно установлена
        assertEquals(mockBun, burger.bun);
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(mockIngredient);  // Добавляем ингредиент
        // Проверяем, что размер списка ингредиентов увеличился на 1
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(mockIngredient);  // Добавляем ингредиент
        burger.removeIngredient(0);  // Удаляем ингредиент по индексу 0
        // Проверяем, что список ингредиентов теперь пуст
        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void testMoveIngredient() {
        burger.addIngredient(mockIngredient);  // Добавляем первый ингредиент
        burger.addIngredient(mockIngredient2); // Добавляем второй ингредиент
        burger.moveIngredient(0, 1);  // Перемещаем первый ингредиент на второе место

        // Проверяем, что ингредиенты поменялись местами
        assertEquals(mockIngredient2, burger.ingredients.get(0));
        assertEquals(mockIngredient, burger.ingredients.get(1));
    }

    @Test
    public void testGetPrice() {
        when(mockBun.getPrice()).thenReturn(100f);  // Устанавливаем цену булочки
        when(mockIngredient.getPrice()).thenReturn(50f);  // Устанавливаем цену ингредиента

        burger.setBuns(mockBun);  // Устанавливаем булочку
        burger.addIngredient(mockIngredient);  // Добавляем ингредиент
        // Проверяем, что цена бургера правильная (булочка * 2 + цена ингредиентов)
        assertEquals(250.0, burger.getPrice(), 0.01);
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

        // Ожидаемый результат чека
        String expectedReceipt = "(==== black bun ====)\n= filling cutlet =\n(==== black bun ====)\n\nPrice: 250.000000\n";

        // Фактический результат, который генерирует метод getReceipt
        String actualReceipt = burger.getReceipt();

        // CRLF на LF для корректного сравнения
        String normalizedExpected = expectedReceipt.replace("\r\n", "\n");
        String normalizedActual = actualReceipt.replace("\r\n", "\n");

        // Сравниваем строки с LF для корректности
        assertEquals("Чек не совпадает с ожидаемым", normalizedExpected, normalizedActual);
    }
}
