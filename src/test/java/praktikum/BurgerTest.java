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

    @Mock
    private Bun mockBun;

    @Mock
    private Ingredient mockSauce;

    @Mock
    private Ingredient mockFilling;

    private Burger burger;

    @Before
    public void setUp() {
        burger = new Burger();

        // Настройка мока для булки
        when(mockBun.getName()).thenReturn("Краторная булка");
        when(mockBun.getPrice()).thenReturn(100f);

        // Настройка моков для ингредиентов
        when(mockSauce.getType()).thenReturn(IngredientType.SAUCE);
        when(mockSauce.getName()).thenReturn("Соус Spicy");
        when(mockSauce.getPrice()).thenReturn(90f);

        // Делаем стабы для mockFilling "ленивыми"
        lenient().when(mockFilling.getType()).thenReturn(IngredientType.FILLING);
        lenient().when(mockFilling.getName()).thenReturn("Говядина");
        lenient().when(mockFilling.getPrice()).thenReturn(200f);
    }

    @Test
    public void testSetBuns() {
        burger.setBuns(mockBun);
        assertEquals(mockBun, burger.bun);
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(mockSauce);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void testAddIngredientContainsAddedIngredient() {
        burger.addIngredient(mockSauce);
        assertEquals(mockSauce, burger.ingredients.get(0));
    }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(mockSauce);
        burger.removeIngredient(0);
        assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void testMoveIngredientChangesPosition() {
        burger.addIngredient(mockSauce);
        burger.addIngredient(mockFilling);
        burger.moveIngredient(0, 1);
        assertEquals(mockSauce, burger.ingredients.get(1));
    }

    @Test
    public void testGetPriceCalculatesCorrectPrice() {
        burger.setBuns(mockBun);
        burger.addIngredient(mockSauce);
        burger.addIngredient(mockFilling);
        float expectedPrice = 100f * 2 + 90f + 200f;
        assertEquals(expectedPrice, burger.getPrice(), 0.01);
    }

    @Test
    public void testGetReceiptReturnsCorrectFormat() {
        burger.setBuns(mockBun);
        burger.addIngredient(mockSauce);

        String receipt = burger.getReceipt();

        // Нормализуем форматирование (заменяем запятые на точки и убираем лишние пробелы)
        String normalizedReceipt = receipt.replace(',', '.').replaceAll("\\s+", " ").trim();

        // Ожидаемый результат с нормализованным форматированием
        String expected = "(==== Краторная булка ====) = sauce Соус Spicy = (==== Краторная булка ====) Price: 290.000000";

        assertEquals(expected, normalizedReceipt);
    }
}