package praktikum.burger;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import praktikum.Bun;
import praktikum.Ingredient;
import praktikum.Burger;

import static org.junit.Assert.assertEquals;

public class BurgerTest {

    private Burger burger; // Объект бургера для тестирования
    private Bun mockBun; // Мок для булочки
    private Ingredient mockIngredient1; // Мок для первого ингредиента
    private Ingredient mockIngredient2; // Мок для второго ингредиента

    @Before
    public void setUp() {
        burger = new Burger();  // Инициализируем бургер перед каждым тестом
        mockBun = Mockito.mock(Bun.class);  // Мокаем булочку
        mockIngredient1 = Mockito.mock(Ingredient.class);  // Мокаем ингредиент 1
        mockIngredient2 = Mockito.mock(Ingredient.class);  // Мокаем ингредиент 2
    }

    @Test
    public void testGetPrice() {
        // Настраиваем моки, задаем цены булочки и ингредиентов
        Mockito.when(mockBun.getPrice()).thenReturn(100f);
        Mockito.when(mockIngredient1.getPrice()).thenReturn(50f);
        Mockito.when(mockIngredient2.getPrice()).thenReturn(75f);

        // Добавляем моки в бургер
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        // Ожидаемая цена: 100 * 2 (две булочки) + 50 + 75 (ингредиенты)
        float expectedPrice = 100 * 2 + 50 + 75;

        // Проверяем корректность расчета цены
        assertEquals(expectedPrice, burger.getPrice(), 0.01);
    }
}
