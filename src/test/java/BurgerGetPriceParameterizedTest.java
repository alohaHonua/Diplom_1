import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import service.TestConstants;

@RunWith(Parameterized.class)
public class BurgerGetPriceParameterizedTest {
    private final float bunPrice;
    private final float ingredientPrice;
    private final int ingredientsNum;
    private final float expectedResult;

    public BurgerGetPriceParameterizedTest(float bunPrice, float ingredientPrice, int ingredientsNum, float expectedResult) {
        this.bunPrice = bunPrice;
        this.ingredientPrice = ingredientPrice;
        this.ingredientsNum = ingredientsNum;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Object[][] dataForTest() {
        return new Object[][]{
                {   1.23f,    4.5f,       1,    6.96f   },
                {   10f,      1.5f,       2,    23f     },
                {   0f,       100.07f,    3,    300.21f },
                {   3.50f,    999.99f,    0,    7f      }
        };
    }

    @Test
    public void getPriceCheckPriceCalculation() {
        Bun bun = Mockito.mock(Bun.class);
        Ingredient ingredient = Mockito.mock(Ingredient.class);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);
        Burger burger = new Burger();
        burger.setBuns(bun);
        for (int i = 0; i < ingredientsNum; i++) {
            burger.addIngredient(ingredient);
        }
        Assert.assertEquals(expectedResult, burger.getPrice(), TestConstants.DELTA);
    }
}
