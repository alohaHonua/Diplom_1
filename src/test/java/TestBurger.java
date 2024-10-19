import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class TestBurger {

    @Mock
    private Bun mockBun;

    @Mock
    private Ingredient mockIngredient1;

    @Mock
    private Ingredient mockIngredient2;

    @Mock
    private Ingredient mockIngredient3;

    @InjectMocks
    private Burger burger;


    // Тестирование установки булочки
    @Test
    public void testSetBuns() {
        // Устанавливаем mock булочку
        burger.setBuns(mockBun);

        // Проверяем, что булочка установлена правильно
        assertEquals(mockBun, burger.bun);
    }

    // Тестирование добавления ингредиентов
    @Test
    public void testAddIngredient() {
        // Добавляем mock ингредиенты
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        // Проверяем, что ингредиенты добавлены в список
        assertEquals(2, burger.ingredients.size());
        assertEquals(mockIngredient1, burger.ingredients.get(0));
        assertEquals(mockIngredient2, burger.ingredients.get(1));
    }

    // Тестирование удаления ингредиента
    @Test
    public void testRemoveIngredient() {
        // Добавляем ингредиенты
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        // Удаляем первый ингредиент
        burger.removeIngredient(0);

        // Проверяем, что остался только второй ингредиент
        assertEquals(1, burger.ingredients.size());
        assertEquals(mockIngredient2, burger.ingredients.get(0));
    }

    // Тестирование перемещения ингредиентов
    @Test
    public void testMoveIngredient() {
        // Добавляем ингредиенты
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        burger.addIngredient(mockIngredient3);

        // Перемещаем третий ингредиент на первую позицию
        burger.moveIngredient(2, 0);

        // Проверяем порядок ингредиентов
        assertEquals(mockIngredient3, burger.ingredients.get(0));
        assertEquals(mockIngredient1, burger.ingredients.get(1));
        assertEquals(mockIngredient2, burger.ingredients.get(2));
    }

    // Тестирование расчета цены бургера
    @Test
    public void testGetPrice() {
        // Задаем поведение mock-объектов
        when(mockBun.getPrice()).thenReturn(100f);
        when(mockIngredient1.getPrice()).thenReturn(50f);
        when(mockIngredient2.getPrice()).thenReturn(30f);

        // Устанавливаем булочку и добавляем ингредиенты
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        // Ожидаемая цена: цена булочки * 2 + цена ингредиентов
        float expectedPrice = 100 * 2 + 50 + 30;

        // Проверяем расчет цены
        assertEquals(expectedPrice, burger.getPrice(), 0);
    }

    // Тестирование генерации квитанции
    @Test
    public void testGetReceipt() {
        // Задаем поведение mock-объектов
        when(mockBun.getName()).thenReturn("Test Bun");
        when(mockBun.getPrice()).thenReturn(100f);

        when(mockIngredient1.getName()).thenReturn("Lettuce");
        when(mockIngredient1.getType()).thenReturn(IngredientType.FILLING);
        when(mockIngredient1.getPrice()).thenReturn(50f);

        when(mockIngredient2.getName()).thenReturn("Tomato");
        when(mockIngredient2.getType()).thenReturn(IngredientType.SAUCE);
        when(mockIngredient2.getPrice()).thenReturn(30f);

        // Устанавливаем булочку и добавляем ингредиенты
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        // Ожидаемая квитанция
        String expectedReceipt = String.format("(==== Test Bun ====)%n" +
                "= filling Lettuce =%n" +
                "= sauce Tomato =%n" +
                "(==== Test Bun ====)%n" +
                "%nPrice: 280,000000%n");// Ожидаемая цена

        // Проверяем квитанцию
        assertEquals(expectedReceipt, burger.getReceipt());
    }
}
