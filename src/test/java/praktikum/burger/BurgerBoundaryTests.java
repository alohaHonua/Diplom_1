package praktikum.burger;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.Bun;
import praktikum.TestConstants;

import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class BurgerBoundaryTests {
    private Burger burger;
    private Bun mockBun;
    private Ingredient mockIngredient1;
    private Ingredient mockIngredient2;

    @Before
    public void setUp() {
        // Инициализация объекта бургера и моков для тестов
        burger = new Burger();
        mockBun = Mockito.mock(Bun.class);
        mockIngredient1 = Mockito.mock(Ingredient.class);
        mockIngredient2 = Mockito.mock(Ingredient.class);

        // Настройка общего поведения моков для булочки
        Mockito.when(mockBun.getPrice()).thenReturn(TestConstants.BLACK_BUN_PRICE);
        Mockito.when(mockBun.getName()).thenReturn(TestConstants.BLACK_BUN_NAME);

        // Устанавливаем локаль для корректного отображения формата цены
        Locale.setDefault(Locale.US);
    }

    // Проверка цены и чека бургера, состоящего только из булочек, без добавленных ингредиентов
    @Test
    public void testBurgerWithOnlyBun() {
        // Устанавливаем булочку для бургера
        burger.setBuns(mockBun);
        // Проверка правильного расчета цены
        assertEquals(TestConstants.EXPECTED_PRICE_WITHOUT_INGREDIENTS, burger.getPrice(), TestConstants.DELTA);
        // Проверка правильности чека для бургера только с булочкой
        assertEquals(TestConstants.EXPECTED_RECEIPT_WITHOUT_INGREDIENTS, burger.getReceipt());
    }



    // Проверка корректного добавления первого ингредиента в бургер
    @Test
    public void testAddFirstIngredient() {
        burger.addIngredient(mockIngredient1);

        // Добавление одного ингредиента должно увеличить размер списка ингредиентов
        assertEquals(TestConstants.EXPECTED_INGREDIENTS_COUNT, burger.ingredients.size());
        assertEquals(mockIngredient1, burger.ingredients.get(TestConstants.FIRST_INDEX));
    }

    // Проверка удаления последнего ингредиента и очистки списка ингредиентов
    @Test
    public void testRemoveLastIngredient() {
        burger.addIngredient(mockIngredient1);
        burger.removeIngredient(TestConstants.FIRST_INDEX);

        // Проверка, что список стал пустым
        assertEquals(TestConstants.EMPTY_INGREDIENTS_COUNT, burger.ingredients.size());
    }

    // Перемещение единственного ингредиента на то же место не должно изменять список
    @Test
    public void testMoveSingleIngredient() {
        burger.addIngredient(mockIngredient1);
        burger.moveIngredient(TestConstants.FIRST_INDEX, TestConstants.FIRST_INDEX);

        // Проверка, что ингредиент остался на месте
        assertEquals(TestConstants.EXPECTED_INGREDIENTS_COUNT, burger.ingredients.size());
        assertEquals(mockIngredient1, burger.ingredients.get(TestConstants.FIRST_INDEX));
    }
}
