import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private static final String TEST_BUN_NAME_1 = "Краторная булка N-200i";
    private static final float TEST_BUN_PRICE_1 = 1255.0f;
    private static final String TEST_BUN_NAME_2 = "Флюоресцентная булка R2-D3";
    private static final float TEST_BUN_PRICE_2 = 988.0f;
    private static final String TEST_SAUCE_NAME = "Соус Spicy-X";
    private static final float TEST_SAUCE_PRICE = 90.0f;
    private static final String TEST_FILLING_NAME = "Говяжий метеорит (отбивная)";
    private static final float TEST_FILLING_PRICE = 3000.0f;

    private Burger burger;

    @Mock
    private Bun mockBun1;

    @Mock
    private Bun mockBun2;

    @Mock
    private Ingredient mockSauce;

    @Mock
    private Ingredient mockFilling;

    @Before // настройка моков
    public void setUp() {
        burger = new Burger();

        when(mockBun1.getName()).thenReturn(TEST_BUN_NAME_1);
        when(mockBun1.getPrice()).thenReturn(TEST_BUN_PRICE_1);
        when(mockBun2.getName()).thenReturn(TEST_BUN_NAME_2);
        when(mockBun2.getPrice()).thenReturn(TEST_BUN_PRICE_2);

        when(mockSauce.getType()).thenReturn(IngredientType.SAUCE);
        when(mockSauce.getName()).thenReturn(TEST_SAUCE_NAME);
        when(mockSauce.getPrice()).thenReturn(TEST_SAUCE_PRICE);

        when(mockFilling.getType()).thenReturn(IngredientType.FILLING);
        when(mockFilling.getName()).thenReturn(TEST_FILLING_NAME);
        when(mockFilling.getPrice()).thenReturn(TEST_FILLING_PRICE);
    }

    // проверка метода setBuns
    @Test
    public void testSetBuns() {
        burger.setBuns(mockBun1);
        assertEquals("Название булочки не совпадает",
                TEST_BUN_NAME_1, burger.bun.getName());
        assertEquals("Цена булочки не совпадает",
                TEST_BUN_PRICE_1, burger.bun.getPrice(), 0.001f);
    }
    @Test
    public void testReplaceBun() {
        burger.setBuns(mockBun1);
        burger.setBuns(mockBun2);
        assertEquals("После замены булочки название не совпало",
                TEST_BUN_NAME_2, burger.bun.getName());
        assertEquals("После замены булочки цена не совпала",
                TEST_BUN_PRICE_2, burger.bun.getPrice(), 0.001f);
    }

    // проверка метода addIngredient
    @Test
    public void testAddIngredient() {
        burger.addIngredient(mockSauce);
        assertEquals("Соус не добавился",
                1, burger.ingredients.size());
        assertEquals("Название добавленного соуса не совпадает",
                TEST_SAUCE_NAME, burger.ingredients.get(0).getName());
    }

    // проверка метода removeIngredient
    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(mockSauce);
        burger.addIngredient(mockFilling);
        burger.removeIngredient(0);
        assertEquals("Неверное количество ингредиентов после удаления",
                1, burger.ingredients.size());
        assertEquals("Удален неверный ингредиент",
                TEST_FILLING_NAME, burger.ingredients.get(0).getName());
    }

    // проверка метода moveIngredient
    @Test
    public void testMoveIngredient() {
        burger.addIngredient(mockSauce);
        burger.addIngredient(mockFilling);
        burger.moveIngredient(0, 1);
        assertEquals("Ингредиенты не переместились",
                TEST_SAUCE_NAME, burger.ingredients.get(1).getName());
        assertEquals("Ингредиенты не переместились",
                TEST_FILLING_NAME, burger.ingredients.get(0).getName());
    }

    // проверка метода getPrice
    @Test
    public void testGetPrice() {
        burger.setBuns(mockBun1);
        burger.addIngredient(mockSauce);
        burger.addIngredient(mockFilling);
        float expectedPrice = TEST_BUN_PRICE_1 * 2 + TEST_SAUCE_PRICE + TEST_FILLING_PRICE;
        assertEquals("Цена рассчитана неверно",
                expectedPrice, burger.getPrice(), 0.001f);
    }

    // проверка метода getReceipt
    @Test
    public void testGetReceipt() {
        burger.setBuns(mockBun1);
        burger.addIngredient(mockSauce);
        burger.addIngredient(mockFilling);

        String receipt = burger.getReceipt();

        assertTrue("В чеке нет названия булочки",
                receipt.contains("(==== " + TEST_BUN_NAME_1 + " ====)"));
        assertTrue("В чеке нет информации о соусе",
                receipt.contains("= sauce " + TEST_SAUCE_NAME + " ="));
        assertTrue("В чеке нет информации о начинке",
                receipt.contains("= filling " + TEST_FILLING_NAME + " ="));
        assertTrue("Цена в чеке рассчитана неверно",
                receipt.contains(String.format("Price: %f",
                        TEST_BUN_PRICE_1 * 2 + TEST_SAUCE_PRICE + TEST_FILLING_PRICE)));
    }
}