package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;

    @Mock
    private Bun bun;
    @Mock
    private Ingredient sauceIngredient;
    @Mock
    private Ingredient fillingIngredient;

    @Before
    public void setUp() {
        burger = new Burger();
        // Настройка моков
        when(bun.getName()).thenReturn("black bun");
        when(bun.getPrice()).thenReturn(100f);

        when(sauceIngredient.getType()).thenReturn(IngredientType.SAUCE);
        when(sauceIngredient.getName()).thenReturn("hot sauce");
        when(sauceIngredient.getPrice()).thenReturn(50f);

        when(fillingIngredient.getType()).thenReturn(IngredientType.FILLING);
        when(fillingIngredient.getName()).thenReturn("cutlet");
        when(fillingIngredient.getPrice()).thenReturn(80f);
    }

    /**
     * Тест проверяет корректность установки булочки в бургер.
     * Проверяет, что после установки булочки, бургер содержит именно ту булочку, которую установили.
     */
    @Test
    public void setBunsShouldCorrectlySetBun() {
        burger.setBuns(bun);
        assertEquals("Название булочки должно совпадать", "black bun", burger.bun.getName());
    }

    /**
     * Тест проверяет добавление ингредиента в бургер.
     * Проверяет, что после добавления ингредиента, количество ингредиентов увеличивается на 1.
     */
    @Test
    public void addIngredientShouldIncreaseIngredientsCount() {
        int initialSize = burger.ingredients.size();
        burger.addIngredient(sauceIngredient);
        assertEquals("Количество ингредиентов должно увеличиться на 1",
                initialSize + 1, burger.ingredients.size());
    }

    /**
     * Тест проверяет удаление ингредиента из бургера.
     * Проверяет, что после удаления ингредиента, количество ингредиентов уменьшается на 1.
     */
    @Test
    public void removeIngredientShouldDecreaseIngredientsCount() {
        burger.addIngredient(sauceIngredient);
        burger.addIngredient(fillingIngredient);
        int initialSize = burger.ingredients.size();

        burger.removeIngredient(0);
        assertEquals("Количество ингредиентов должно уменьшиться на 1",
                initialSize - 1, burger.ingredients.size());
    }

    /**
     * Тест проверяет перемещение ингредиента в бургере.
     * Проверяет, что после перемещения ингредиент находится на новой позиции.
     */
    @Test
    public void moveIngredientShouldChangeIngredientsOrder() {
        burger.addIngredient(sauceIngredient);
        burger.addIngredient(fillingIngredient);

        burger.moveIngredient(0, 1);
        assertEquals("Ингредиент должен быть перемещен на новую позицию",
                "hot sauce", burger.ingredients.get(1).getName());
    }

    /**
     * Тест проверяет расчет стоимости бургера.
     * Проверяет, что цена рассчитывается корректно: цена булочки * 2 + сумма цен ингредиентов.
     */
    @Test
    public void getPriceShouldReturnCorrectTotalPrice() {
        burger.setBuns(bun);
        burger.addIngredient(sauceIngredient);
        burger.addIngredient(fillingIngredient);

        float expectedPrice = bun.getPrice() * 2 + sauceIngredient.getPrice() + fillingIngredient.getPrice();
        assertEquals("Общая цена должна быть рассчитана правильно",
                expectedPrice, burger.getPrice(), 0.01f);
    }

    /**
     * Тест проверяет генерацию чека для бургера.
     * Проверяет, что чек содержит все необходимые элементы:
     * - Названия булочек
     * - Названия и типы ингредиентов
     * - Общую стоимость
     */
    @Test
    public void getReceiptShouldContainAllBurgerComponents() {
        burger.setBuns(bun);
        burger.addIngredient(sauceIngredient);
        burger.addIngredient(fillingIngredient);

        String receipt = burger.getReceipt();
        assertTrue("Чек должен содержать название булочки", receipt.contains("black bun"));
        assertTrue("Чек должен содержать название соуса", receipt.contains("hot sauce"));
        assertTrue("Чек должен содержать название начинки", receipt.contains("cutlet"));
        assertTrue("Чек должен содержать общую стоимость", receipt.contains("Price:"));
    }
}