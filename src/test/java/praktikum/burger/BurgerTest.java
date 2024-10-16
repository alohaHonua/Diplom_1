package praktikum.burger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import praktikum.Bun;
import praktikum.Ingredient;
import praktikum.Burger;
import praktikum.TestConstants;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BurgerTest {

    private Burger burger;
    private Bun mockBun;
    private List<Ingredient> mockIngredients;
    private final float expectedPrice;

    public BurgerTest(List<Ingredient> mockIngredients, float expectedPrice) {
        this.mockIngredients = mockIngredients;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                // Сценарий с одним ингредиентом
                { Arrays.asList(
                        new Ingredient(TestConstants.INGREDIENT1_TYPE, TestConstants.INGREDIENT1_NAME, TestConstants.INGREDIENT1_PRICE)),
                        TestConstants.BLACK_BUN_PRICE * 2 + TestConstants.INGREDIENT1_PRICE },

                // Сценарий с двумя ингредиентами
                { Arrays.asList(
                        new Ingredient(TestConstants.INGREDIENT1_TYPE, TestConstants.INGREDIENT1_NAME, TestConstants.INGREDIENT1_PRICE),
                        new Ingredient(TestConstants.INGREDIENT2_TYPE, TestConstants.INGREDIENT2_NAME, TestConstants.INGREDIENT2_PRICE)),
                        TestConstants.BLACK_BUN_PRICE * 2 + TestConstants.INGREDIENT1_PRICE + TestConstants.INGREDIENT2_PRICE },

                // Сценарий с тремя ингредиентами
                { Arrays.asList(
                        new Ingredient(TestConstants.INGREDIENT1_TYPE, TestConstants.INGREDIENT1_NAME, TestConstants.INGREDIENT1_PRICE),
                        new Ingredient(TestConstants.INGREDIENT2_TYPE, TestConstants.INGREDIENT2_NAME, TestConstants.INGREDIENT2_PRICE),
                        new Ingredient(TestConstants.INGREDIENT3_TYPE, TestConstants.INGREDIENT3_NAME, TestConstants.INGREDIENT3_PRICE)),
                        TestConstants.BLACK_BUN_PRICE * 2 + TestConstants.INGREDIENT1_PRICE + TestConstants.INGREDIENT2_PRICE + TestConstants.INGREDIENT3_PRICE }
        });
    }

    @Before
    public void setUp() {
        burger = new Burger();
        mockBun = Mockito.mock(Bun.class);
        Mockito.when(mockBun.getPrice()).thenReturn(TestConstants.BLACK_BUN_PRICE);
        burger.setBuns(mockBun);

        for (Ingredient ingredient : mockIngredients) {
            burger.addIngredient(ingredient);
        }
    }
    // Проверка корректности расчета цены бургера с булочкой и разным количеством ингредиентов
    @Test
    public void testPriceCalculationWithDifferentIngredients() {
        assertEquals(expectedPrice, burger.getPrice(), TestConstants.DELTA);
    }
}
