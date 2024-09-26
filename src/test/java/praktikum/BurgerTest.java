package praktikum;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * Тесты для класса Burger.
 * В тестах используется Mockito для создания моков (заглушек) объектов, таких как Bun и Ingredient.
 */
public class BurgerTest {

    // Переменная AutoCloseable для закрытия моков после тестов
    private AutoCloseable closeable;

    // @Mock указывает на создание мока для объекта Bun
    @Mock
    private Bun bun;

    // @Mock указывает на создание мока для объекта Ingredient
    @Mock
    private Ingredient ingredient;

    // Еще один мок для второго ингредиента
    @Mock
    private Ingredient oneMoreIngredient;

    // @Spy указывает, что объект Burger будет частично мокирован,
    // но его реальные методы будут вызваны, если они не замокированы.
    @Spy
    private Burger burger;

    /**
     * @Before указывает, что этот метод будет выполняться перед каждым тестом.
     * Здесь инициализируются моки и задаются необходимые поведенческие сценарии для моков с помощью Mockito.
     */
    @Before
    public void setupTest() {
        // Инициализация моков
        closeable = MockitoAnnotations.openMocks(this);

        // Настраиваем поведение мока для объекта Bun
        when(bun.getName()).thenReturn("Мягкая французская булочка");
        when(bun.getPrice()).thenReturn(0.25f);

        // Настраиваем поведение мока для первого ингредиента
        when(ingredient.getPrice()).thenReturn(0.15f);
        when(ingredient.getName()).thenReturn("chili sauce");
        when(ingredient.getType()).thenReturn(IngredientType.SAUCE);

        // Настраиваем поведение мока для второго ингредиента
        when(oneMoreIngredient.getPrice()).thenReturn(0.15f);
        when(oneMoreIngredient.getName()).thenReturn("cutlet");
        when(oneMoreIngredient.getType()).thenReturn(IngredientType.FILLING);
    }

    /**
     * @Test указывает, что этот метод является тестовым.
     * Проверяем, что метод setBuns был вызван 1 раз и что булка была корректно установлена в бургер.
     */
    @Test
    public void setBunsCallSetBunsIsCalled() {
        burger.setBuns(bun);
        // Проверяем, что метод setBuns был вызван 1 раз
        Mockito.verify(burger, Mockito.times(1)).setBuns(bun);
        // Проверяем, что объект bun был установлен
        assertNotNull(burger.bun);
    }

    /**
     * Тест для метода addIngredient.
     * Проверяем, что ингредиент был добавлен в бургер.
     */
    @Test
    public void addIngredientIngredientAdded() {
        burger.addIngredient(ingredient);
        // Проверяем, что ингредиент добавлен в список ингредиентов бургера
        assertNotNull(burger.ingredients.get(0));
    }

    /**
     * Тест для метода removeIngredient.
     * Проверяем, что ингредиент удаляется из бургера.
     */
    @Test
    public void removeIngredientIngredientRemoved() {
        // Добавляем ингредиент в список
        burger.ingredients.add(ingredient);
        // Удаляем его
        burger.removeIngredient(0);
        // Проверяем, что список ингредиентов пустой
        assertTrue(burger.ingredients.isEmpty());
    }

    /**
     * Тест для метода moveIngredient.
     * Проверяем, что ингредиент перемещается в списке ингредиентов.
     */
    @Test
    public void moveIngredientIngredientMoved() {
        // Добавляем два ингредиента в список
        burger.ingredients.addAll(List.of(ingredient, oneMoreIngredient));
        // Перемещаем второй ингредиент на первую позицию
        burger.moveIngredient(1, 0);
        // Вызываем метод getName для проверки перемещения
        burger.ingredients.get(1).getName();
        // Проверяем, что для перемещенного ингредиента был вызван метод getName
        Mockito.verify(ingredient).getName();
    }

    /**
     * Тест для метода getPrice.
     * Проверяем, что общая цена бургера рассчитывается корректно.
     */
    @Test
    public void getPriceReturnedPriceOfTheBurger() {
        // Устанавливаем булочку и ингредиенты для бургера
        burger.setBuns(bun);
        burger.ingredients.addAll(List.of(ingredient, oneMoreIngredient));
        // Ожидаемая цена: 2 * 0.25 (цена булочек) + 0.15 + 0.15 (ингредиенты) = 0.8
        assertEquals(0.8, burger.getPrice(), 0.01);
    }

    /**
     * Тест для метода getReceipt.
     * Проверяем, что правильный чек бургера формируется корректно.
     */
    @Test
    public void getReceiptCorrectReceiptReceived() {
        // Устанавливаем булочку и ингредиенты для бургера
        burger.setBuns(bun);
        burger.ingredients.addAll(List.of(ingredient, oneMoreIngredient));
        // Ожидаемая строка чека
        String expected = "(==== Мягкая французская булочка ====)\n" +
                "= sauce chili sauce =\n" +
                "= filling cutlet =\n" +
                "(==== Мягкая французская булочка ====)\n" +
                "\nPrice: 0,800000\n";
        // Проверяем, что реальный чек совпадает с ожидаемым
        assertEquals(expected, burger.getReceipt());
    }

    /**
     * @After указывает, что этот метод будет выполнен после каждого теста.
     * Здесь закрываем моки, чтобы очистить ресурсы.
     */
    @After
    public void teardownTest() throws Exception {
        // Закрываем моки
        closeable.close();
    }
}
