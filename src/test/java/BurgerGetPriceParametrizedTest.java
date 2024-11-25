import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

@RunWith(Parameterized.class)
public class BurgerGetPriceParametrizedTest {
    private final float BUN_PRICE;
    private final float INGREDIENT_PRICE;
    private final int INGREDIENTS_NUM;
    private final float EXPECTED_RESULT;

    public BurgerGetPriceParametrizedTest(float BUN_PRICE, float INGREDIENT_PRICE, int INGREDIENTS_NUM, float EXPECTED_RESULT) {
        this.BUN_PRICE = BUN_PRICE;
        this.INGREDIENT_PRICE = INGREDIENT_PRICE;
        this.INGREDIENTS_NUM = INGREDIENTS_NUM;
        this.EXPECTED_RESULT = EXPECTED_RESULT;
    }

    @Parameterized.Parameters
    public static Object[][] dataForTest() {
        return new Object[][]{
                {   1.23f,    4.5f,       1,    6.96f   },
                {   10f,      1.5f,       2,    23f     },
                {   0f,       100.07f,    3,    300.21f },
                {   3.50f,    999.99f,    0,    7f      },
                {   0,        0,          0,    0       }
        };
    }

    @Test
    public void getPriceCheckPriceCalculation() {
        Bun bun = Mockito.mock(Bun.class);
        Ingredient ingredient = Mockito.mock(Ingredient.class);
        Mockito.when(bun.getPrice()).thenReturn(BUN_PRICE);
        Mockito.when(ingredient.getPrice()).thenReturn(INGREDIENT_PRICE);
        Burger burger = new Burger();
        burger.setBuns(bun);
        for (int i = 0; i < INGREDIENTS_NUM; i++) {
            burger.addIngredient(ingredient);
        }
        Assert.assertEquals(EXPECTED_RESULT, burger.getPrice(), 0.001f);
    }
}
