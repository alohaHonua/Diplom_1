package praktikum.burger;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import praktikum.Bun;
import praktikum.Ingredient;
import praktikum.Burger;
import praktikum.TestConstants;

import static org.junit.Assert.assertEquals;

public class BurgerTest {
    private Burger burger; // Объект бургера для тестирования
    private Bun mockBun; // Мок для булочки
    private Ingredient mockIngredient1; // Мок для первого ингредиента
    private Ingredient mockIngredient2; // Мок для второго ингредиента

    @Before
    public void setUp() {
        // Инициализируем бургер и моки перед каждым тестом
        burger = new Burger();
        mockBun = Mockito.mock(Bun.class);
        mockIngredient1 = Mockito.mock(Ingredient.class);
        mockIngredient2 = Mockito.mock(Ingredient.class);

        // Настраиваем моки
        Mockito.when(mockBun.getPrice()).thenReturn(TestConstants.BUN_PRICE);
        Mockito.when(mockIngredient1.getPrice()).thenReturn(TestConstants.INGREDIENT1_PRICE);
        Mockito.when(mockIngredient2.getPrice()).thenReturn(TestConstants.INGREDIENT2_PRICE);
    }
    // Проверка корректности расчета цены бургера с булочкой и двумя ингредиентами.
    @Test
    public void testGetPrice() {
        // Добавляем моки в бургер
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        // Проверяем корректность расчета цены
        assertEquals(TestConstants.EXPECTED_PRICE, burger.getPrice(), TestConstants.DELTA);
    }
}
