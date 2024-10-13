package praktikum.burger;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BurgerBoundaryTests {

    private Burger burger;
    private Bun mockBun;
    private Ingredient mockIngredient1;
    private Ingredient mockIngredient2;

    @Before
    public void setUp() {
        burger = new Burger();
        mockBun = Mockito.mock(Bun.class);
        mockIngredient1 = Mockito.mock(Ingredient.class);
        mockIngredient2 = Mockito.mock(Ingredient.class);
    }

    // Тест: проверка бургера только с булочкой (без ингредиентов)
    @Test
    public void testBurgerWithOnlyBun() {
        // Устанавливаем мок для булочки
        Mockito.when(mockBun.getPrice()).thenReturn(100f);
        burger.setBuns(mockBun);

        // Ожидаемая цена: 100 * 2 (две булочки, без ингредиентов)
        float expectedPrice = 100 * 2;
        assertEquals(expectedPrice, burger.getPrice(), 0.01);

        // Проверка получения чека для бургера только с булочкой
        String expectedReceipt = "(==== black bun ====)\n" +
                "(==== black bun ====)\n" +
                "\nPrice: 200.00\n";  // Ожидаемая строка с двумя знаками после запятой

        Mockito.when(mockBun.getName()).thenReturn("black bun");
        assertEquals(expectedReceipt, burger.getReceipt());
    }


    // Тест: добавление первого ингредиента
    @Test
    public void testAddFirstIngredient() {
        // Добавляем первый ингредиент
        burger.addIngredient(mockIngredient1);

        // Проверяем, что добавлен 1 ингредиент
        assertEquals(1, burger.ingredients.size());
        assertEquals(mockIngredient1, burger.ingredients.get(0));
    }

    // Тест: попытка удалить ингредиент из пустого списка должна выбросить IndexOutOfBoundsException
    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveIngredientFromEmptyList() {
        // Пытаемся удалить ингредиент из пустого списка
        burger.removeIngredient(0);
    }

    // Тест: добавление и удаление последнего ингредиента
    @Test
    public void testRemoveLastIngredient() {
        // Добавляем один ингредиент
        burger.addIngredient(mockIngredient1);

        // Удаляем ингредиент
        burger.removeIngredient(0);

        // Проверяем, что список стал пустым
        assertEquals(0, burger.ingredients.size());
    }

    // Тест: попытка переместить ингредиент на недопустимый индекс должна выбросить IndexOutOfBoundsException
    @Test(expected = IndexOutOfBoundsException.class)
    public void testMoveIngredientInvalidIndex() {
        // Добавляем два ингредиента
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        // Пытаемся переместить ингредиент с недопустимым индексом
        burger.moveIngredient(5, 1);  // Индекс 5 за пределами списка
    }

    // Тест: перемещение единственного ингредиента, который останется на месте
    @Test
    public void testMoveSingleIngredient() {
        // Добавляем один ингредиент
        burger.addIngredient(mockIngredient1);

        // Перемещаем единственный ингредиент (он останется на месте)
        burger.moveIngredient(0, 0);

        // Проверяем, что список не изменился
        assertEquals(1, burger.ingredients.size());
        assertEquals(mockIngredient1, burger.ingredients.get(0));
    }
}
