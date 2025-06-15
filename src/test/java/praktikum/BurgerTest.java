package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    // Моки для компонентов бургера
    @Mock
    private Bun bunMock;

    @Mock
    private Ingredient sauceMock;

    @Mock
    private Ingredient fillingMock;

    private Burger testBurger;

    // Подготовка тестового окружения перед каждым тестом
    @Before
    public void initialize() {
        testBurger = new Burger();

        // Конфигурация мока для булочки
        when(bunMock.getName()).thenReturn("Звездная булка");
        when(bunMock.getPrice()).thenReturn(100f);

        // Конфигурация мока для соуса
        when(sauceMock.getType()).thenReturn(IngredientType.SAUCE);
        when(sauceMock.getName()).thenReturn("Острый соус");
        when(sauceMock.getPrice()).thenReturn(90f);

        // Ленивая конфигурация мока для начинки
        lenient().when(fillingMock.getType()).thenReturn(IngredientType.FILLING);
        lenient().when(fillingMock.getName()).thenReturn("Мясная котлета");
        lenient().when(fillingMock.getPrice()).thenReturn(200f);
    }

    // Проверка установки булочек в бургер
    @Test
    public void verifySetBuns() {
        testBurger.setBuns(bunMock);
        assertEquals("Булочка должна быть установлена корректно", bunMock, testBurger.bun);
    }

    // Проверка добавления ингредиента
    @Test
    public void verifyAddIngredientIncreasesSize() {
        testBurger.addIngredient(sauceMock);
        assertEquals("Размер списка ингредиентов должен быть 1", 1, testBurger.ingredients.size());
    }

    // Проверка, что добавленный ингредиент присутствует в списке
    @Test
    public void verifyAddedIngredientIsCorrect() {
        testBurger.addIngredient(sauceMock);
        assertEquals("Добавленный ингредиент должен быть в списке", sauceMock, testBurger.ingredients.get(0));
    }

    // Проверка удаления ингредиента
    @Test
    public void verifyRemoveIngredientClearsList() {
        testBurger.addIngredient(sauceMock);
        testBurger.removeIngredient(0);
        assertTrue("Список ингредиентов должен быть пустым после удаления", testBurger.ingredients.isEmpty());
    }

    // Проверка изменения позиции ингредиента
    @Test
    public void verifyMoveIngredientUpdatesPosition() {
        testBurger.addIngredient(sauceMock);
        testBurger.addIngredient(fillingMock);
        testBurger.moveIngredient(0, 1);
        assertEquals("Ингредиент должен быть перемещен на новую позицию", sauceMock, testBurger.ingredients.get(1));
    }

    // Проверка расчета общей стоимости бургера
    @Test
    public void verifyPriceCalculation() {
        testBurger.setBuns(bunMock);
        testBurger.addIngredient(sauceMock);
        testBurger.addIngredient(fillingMock);
        float expectedPrice = 100f * 2 + 90f + 200f; // Две булочки + соус + начинка
        assertEquals("Общая стоимость должна быть рассчитана корректно", expectedPrice, testBurger.getPrice(), 0.01);
    }

    // Проверка формата чека
    @Test
    public void verifyReceiptFormat() {
        testBurger.setBuns(bunMock);
        testBurger.addIngredient(sauceMock);

        String receipt = testBurger.getReceipt();

        // Нормализация чека для проверки
        String normalizedReceipt = receipt.replace(',', '.').replaceAll("\\s+", " ").trim();

        // Ожидаемый формат чека
        String expectedReceipt = "(==== Звездная булка ====) = sauce Острый соус = (==== Звездная булка ====) Price: 290.000000";

        assertEquals("Чек должен соответствовать ожидаемому формату", expectedReceipt, normalizedReceipt);
    }
}