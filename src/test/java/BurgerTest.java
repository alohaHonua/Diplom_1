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
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;

    // Создание мока для булочки
    @Mock
    private Bun bun;

    // Создание мока для ингридиентов
    @Mock
    private Ingredient firstIngredient;

    @Mock
    private Ingredient secondIngredient;

    @Mock
    private Ingredient thirdIngredient;

    @Before
    public void setUp() {

        // Создание нового экземпляра класса Burger перед каждым тестом
        burger = new Burger();
    }

    @Test
    public void testSetBuns() {

        // Подготовка данных
        burger.setBuns(bun);
        when(bun.getName()).thenReturn(Constants.EXPECTED_BUN_NAME);

        // Проверка результата. Сравнение фактического имени булочки с ожидаемым значением
        assertEquals("Булочка установлена неверно", Constants.EXPECTED_BUN_NAME,
                burger.bun.getName());
    }

    @Test
    public void testAddIngredient() {

        // Добавление первого ингредиента в бургер
        burger.addIngredient(firstIngredient);

        // Проверяем количество ингредиентов в бургере
        assertEquals("В бургере ожидался 1 ингредиент", 1,
                burger.ingredients.size());

        // Проверяем наличие конкретного ингредиента в списке ингредиентов бургера
        assertTrue("В бургер не был добавлен ингредиент",
                burger.ingredients.contains(firstIngredient));
    }

    @Test
    public void testRemoveIngredient() {

        // Добавляем три ингредиента в бургер
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.addIngredient(thirdIngredient);


        // Удаление ингредиента по индексу
        burger.removeIngredient(Constants.INDEX_TO_REMOVE);


        assertEquals("Не был удалён ингредиент", 2, burger.ingredients.size());
        assertTrue("Удалён неверный ингредиент",
                burger.ingredients.contains(firstIngredient) &&
                        burger.ingredients.contains(thirdIngredient) &&
                        !burger.ingredients.contains(secondIngredient));
    }

    @Test
    public void testMoveIngredient() {

        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.addIngredient(thirdIngredient);

        // Перемещаем ингредиент с одного индекса на другой
        burger.moveIngredient(Constants.FROM_INDEX, Constants.TO_INDEX);

        assertEquals("Ингредиенты не переместились", secondIngredient,
                burger.ingredients.get(0));
        assertEquals("Ингредиенты не переместились", firstIngredient,
                burger.ingredients.get(1));
    }

    @Test
    public void testGetPrice() {
        burger.setBuns(bun);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.addIngredient(thirdIngredient);

        // Определяем, какие значения будут возвращаться методами getPrice() у моков
        when(bun.getPrice()).thenReturn(Constants.EXPECTED_BUN_PRICE);
        when(firstIngredient.getPrice()).thenReturn(Constants.EXPECTED_FIRST_INGREDIENT_PRICE);
        when(secondIngredient.getPrice()).thenReturn(Constants.EXPECTED_SECOND_INGREDIENT_PRICE);
        when(thirdIngredient.getPrice()).thenReturn(Constants.EXPECTED_THIRD_INGREDIENT_PRICE);

        // Получаем общую стоимость бургера
        float actualPrice = burger.getPrice();

        assertEquals("Неверная цена за бургер", Constants.EXPECTED_TOTAL_PRICE,
                actualPrice, 0.01f);
    }

    @Test
    public void testGetReceipt() {
        burger.setBuns(bun);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.addIngredient(thirdIngredient);

        // Определяем поведение моков
        when(bun.getName()).thenReturn(Constants.EXPECTED_BUN_NAME);
        when(bun.getPrice()).thenReturn(Constants.EXPECTED_BUN_PRICE);

        when(firstIngredient.getType()).thenReturn(IngredientType.FILLING);
        when(secondIngredient.getType()).thenReturn(IngredientType.FILLING);
        when(thirdIngredient.getType()).thenReturn(IngredientType.SAUCE);

        when(firstIngredient.getName()).thenReturn(Constants.EXPECTED_FIRST_INGREDIENT_NAME);
        when(secondIngredient.getName()).thenReturn(Constants.EXPECTED_SECOND_INGREDIENT_NAME);
        when(thirdIngredient.getName()).thenReturn(Constants.EXPECTED_THIRD_INGREDIENT_NAME);

        when(firstIngredient.getPrice()).thenReturn(Constants.EXPECTED_FIRST_INGREDIENT_PRICE);
        when(secondIngredient.getPrice()).thenReturn(Constants.EXPECTED_SECOND_INGREDIENT_PRICE);
        when(thirdIngredient.getPrice()).thenReturn(Constants.EXPECTED_THIRD_INGREDIENT_PRICE);

        // Формируем ожидаемый чек
        String expectedReceipt = String.format(
                "(==== %s ====)%s= %s %s =%s= %s %s =%s= %s %s =%s(==== %s ====)%s%nPrice: %.6f%s",
                Constants.EXPECTED_BUN_NAME, System.lineSeparator(),
                "filling", Constants.EXPECTED_FIRST_INGREDIENT_NAME, System.lineSeparator(),
                "filling", Constants.EXPECTED_SECOND_INGREDIENT_NAME, System.lineSeparator(),
                "sauce", Constants.EXPECTED_THIRD_INGREDIENT_NAME, System.lineSeparator(),
                Constants.EXPECTED_BUN_NAME, System.lineSeparator(),
                Constants.EXPECTED_TOTAL_PRICE, System.lineSeparator()
        );

        // Получаем фактический чек от бургера
        String actualReceipt = burger.getReceipt();

        // Сравниваем ожидаемый и фактический чек
        assertEquals("Неверное формирование чека", expectedReceipt, actualReceipt);
    }
}
