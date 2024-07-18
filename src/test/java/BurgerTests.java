import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class BurgerTests {

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this); // Инициализация Mock объектов перед каждым тестом
    }

    @Mock
    private Bun mockBun; // Mock булочки

    @Mock
    private Ingredient mockIngredient1; // Mock первого ингредиента

    @Mock
    private Ingredient mockIngredient2; // Mock второго ингредиента

    @Test
    public void testSetBuns(){
        Burger burger = new Burger();
        burger.setBuns(mockBun); // Устанавливаем Mock булочку в бургер

        assertEquals(mockBun, burger.bun); // Проверяем, что булочка в бургере такая же, как Mock булочка
    }

    @Test
    public void testAddIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(mockIngredient1); // Добавляем Mock ингредиент в бургер

        assertEquals(1, burger.ingredients.size()); // Проверяем, что в бургере один ингредиент
    }

    @Test
    public void testRemoveIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(mockIngredient1); // Добавляем Mock ингредиент в бургер
        burger.removeIngredient(0); // Удаляем ингредиент из бургера индекс 0

        assertEquals(0, burger.ingredients.size()); // Проверяем, что ингредиентов в бургере больше нет
    }

    @Test
    public void testMoveIngredient() {
        Burger burger = new Burger();

        burger.addIngredient(mockIngredient1); // Добавляем первый Mock ингредиент
        burger.addIngredient(mockIngredient2); // Добавляем второй Mock ингредиент

        burger.moveIngredient(0, 1); // Перемещаем ингредиент с позиции 0 на позицию 1

        assertEquals(mockIngredient2, burger.ingredients.get(0)); // Проверяем, что на позиции 0 теперь второй ингредиент
        assertEquals(mockIngredient1, burger.ingredients.get(1)); // Проверяем, что на позиции 1 теперь первый ингредиент
    }

    @Test
    public void testGetPrice() {
        Burger burger = new Burger();

        // Устанавливаем ожидаемые цены для Mock объектов
        when(mockBun.getPrice()).thenReturn(3.0f);
        when(mockIngredient1.getPrice()).thenReturn(1.0f);
        when(mockIngredient2.getPrice()).thenReturn(2.0f);

        burger.setBuns(mockBun); // Устанавливаем Mock булочку
        burger.addIngredient(mockIngredient1); // Добавляем первый Mock ингредиент
        burger.addIngredient(mockIngredient2); // Добавляем второй Mock ингредиент

        float expectedPrice = 3.0f * 2 + 1.0f + 2.0f; // Ожидаемая цена бургера (цена булочки * 2 + цена первого ингредиента + цена второго ингредиента)

        float actualPrice = burger.getPrice(); // Получаем фактическую цену бургера

        assertEquals(expectedPrice, actualPrice, 0.01); // Проверяем, что фактическая цена соответствует ожидаемой с точностью до 0.01
    }

    @Test
    public void testGetReceipt() {
        Burger burger = new Burger();

        // Устанавливаем ожидаемые значения для Mock объектов
        when(mockBun.getName()).thenReturn("BunName");
        when(mockIngredient1.getType()).thenReturn(IngredientType.SAUCE);
        when(mockIngredient1.getName()).thenReturn("SauceName");
        when(mockIngredient2.getType()).thenReturn(IngredientType.FILLING);
        when(mockIngredient2.getName()).thenReturn("FillingName");

        burger.setBuns(mockBun); // Устанавливаем Mock булочку в бургер
        burger.addIngredient(mockIngredient1); // Добавляем первый Mock ингредиент в бургер
        burger.addIngredient(mockIngredient2); // Добавляем второй Mock ингредиент в бургер

        // Ожидаемый чек бургера
        String expectedReceipt = "(==== BunName ====)\n" +
                "= sauce SauceName =\n" +
                "= filling FillingName =\n" +
                "(==== BunName ====)\n" +
                "\nPrice: 0,000000\n";

        String actualReceipt = burger.getReceipt(); // Получаем фактический чек бургера
        expectedReceipt = expectedReceipt.replace("\n", System.lineSeparator()); // Заменяем символы перевода строки для корректного сравнения

        assertEquals(expectedReceipt, actualReceipt); // Проверяем, что фактический чек соответствует ожидаемому
    }
}