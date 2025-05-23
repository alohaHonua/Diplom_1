import org.assertj.core.data.Offset;
import org.junit.*;
import org.junit.runner.*;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.assertj.core.api.SoftAssertions;

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
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(burger.bun.getName())
                .as("Название булочки не совпадает")
                .isEqualTo(TEST_BUN_NAME_1);
        softly.assertThat(burger.bun.getPrice())
                .as("Цена булочки не совпадает")
                .isCloseTo(TEST_BUN_PRICE_1, Offset.offset(0.001f));
        softly.assertAll();
    }
    @Test
    public void testReplaceBun() {
        burger.setBuns(mockBun1);
        burger.setBuns(mockBun2);
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(burger.bun.getName())
                .as("После замены булочки название не совпало")
                .isEqualTo(TEST_BUN_NAME_2);
        softly.assertThat(burger.bun.getPrice())
                .as("После замены булочки цена не совпала")
                .isCloseTo(TEST_BUN_PRICE_2, Offset.offset(0.001f));
        softly.assertAll();
    }

    // проверка метода addIngredient
    @Test
    public void testAddIngredient() {
        burger.addIngredient(mockSauce);
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(burger.ingredients)
                .as("Соус не добавился")
                .hasSize(1);
        softly.assertThat(burger.ingredients.get(0).getName())
                .as("Название добавленного соуса не совпадает")
                .isEqualTo(TEST_SAUCE_NAME);
        softly.assertAll();
    }

    // проверка метода removeIngredient
    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(mockSauce);
        burger.addIngredient(mockFilling);
        burger.removeIngredient(0);
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(burger.ingredients)
                .as("Неверное количество ингредиентов после удаления")
                .hasSize(1);
        softly.assertThat(burger.ingredients.get(0).getName())
                .as("Удален неверный ингредиент")
                .isEqualTo(TEST_FILLING_NAME);
        softly.assertAll();
    }

    // проверка метода moveIngredient
    @Test
    public void testMoveIngredient() {
        burger.addIngredient(mockSauce);
        burger.addIngredient(mockFilling);
        burger.moveIngredient(0, 1);
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(burger.ingredients.get(1).getName())
                .as("Ингредиенты не переместились")
                .isEqualTo(TEST_SAUCE_NAME);
        softly.assertThat(burger.ingredients.get(0).getName())
                .as("Ингредиенты не переместились")
                .isEqualTo(TEST_FILLING_NAME);
        softly.assertAll();
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
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(receipt)
                .as("В чеке нет названия булочки")
                .contains("(==== " + TEST_BUN_NAME_1 + " ====)");
        softly.assertThat(receipt)
                .as("В чеке нет информации о соусе")
                .contains("= sauce " + TEST_SAUCE_NAME + " =");
        softly.assertThat(receipt)
                .as("В чеке нет информации о начинке")
                .contains("= filling " + TEST_FILLING_NAME + " =");
        softly.assertThat(receipt)
                .as("Цена в чеке рассчитана неверно")
                .contains(String.format("Price: %f",
                        TEST_BUN_PRICE_1 * 2 + TEST_SAUCE_PRICE + TEST_FILLING_PRICE));
        softly.assertAll();
    }
}