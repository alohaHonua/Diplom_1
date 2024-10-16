package praktikum.burger;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.TestConstants;

import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class BurgerGetReceiptTest {

    private Burger burger;
    private Bun mockBun;
    private Ingredient mockIngredient;

    @Before
    public void setUp() {
        burger = new Burger();
        mockBun = Mockito.mock(Bun.class);
        mockIngredient = Mockito.mock(Ingredient.class);

        // Настраиваем моки
        Mockito.when(mockBun.getName()).thenReturn(TestConstants.BLACK_BUN_NAME);
        Mockito.when(mockBun.getPrice()).thenReturn(TestConstants.BLACK_BUN_PRICE);
        Mockito.when(mockIngredient.getName()).thenReturn(TestConstants.INGREDIENT2_NAME);
        Mockito.when(mockIngredient.getType()).thenReturn(TestConstants.INGREDIENT2_TYPE);
        Mockito.when(mockIngredient.getPrice()).thenReturn(TestConstants.INGREDIENT2_PRICE);

        // Собираем бургер
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient);

        // Устанавливаем локаль для корректного отображения формата цены
        Locale.setDefault(Locale.US);
    }
    // Проверка правильности чека для бургера с ингредиентом
    @Test
    public void testGetReceiptWithIngredient() {
        assertEquals(TestConstants.EXPECTED_RECEIPT_WITH_INGREDIENT, burger.getReceipt());
    }

}
