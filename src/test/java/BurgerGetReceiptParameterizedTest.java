import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class BurgerGetReceiptParameterizedTest {
    private final IngredientType ingredientType;
    private final String ingredientName;
    private final int ingredientsNum;
    private final String bunName;
    private final float burgerPrice;
    private final String expectedResult;

    public BurgerGetReceiptParameterizedTest(IngredientType ingredientType, String ingredientName, int ingredientsNum, String bunName, float burgerPrice, String expectedResult) {
        this.ingredientType = ingredientType;
        this.ingredientName = ingredientName;
        this.ingredientsNum = ingredientsNum;
        this.bunName = bunName;
        this.burgerPrice = burgerPrice;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Object[][] dataForTest() {
        return new Object[][]{
                {
                        IngredientType.SAUCE,
                        "Соус Spicy-X",
                        1,
                        "Краторная булка N-200i",
                        2600f,
                        "(==== Краторная булка N-200i ====)\r\n" +
                        "= sauce Соус Spicy-X =\r\n" +
                        "(==== Краторная булка N-200i ====)\r\n" +
                        "\r\n" +
                        "Price: 2600,000000"
                },
                {
                        IngredientType.FILLING,
                        "Говяжий метеорит (отбивная)",
                        2,
                        "Флюоресцентная булка R2-D3",
                        7976f,
                        "(==== Флюоресцентная булка R2-D3 ====)\r\n" +
                        "= filling Говяжий метеорит (отбивная) =\r\n" +
                        "= filling Говяжий метеорит (отбивная) =\r\n" +
                        "(==== Флюоресцентная булка R2-D3 ====)\r\n" +
                        "\r\n" +
                        "Price: 7976,000000"
                },
                {
                        IngredientType.SAUCE,
                        "Кристаллы марсианских альфа-сахаридов",
                        0,
                        "Краторная булка N-200i",
                        2510f,
                        "(==== Краторная булка N-200i ====)\r\n" +
                        "(==== Краторная булка N-200i ====)\r\n" +
                        "\r\n" +
                        "Price: 2510,000000"
                },
        };
    }

    @Test
    public void getReceiptCheckReceiptText() {
        Ingredient ingredient = Mockito.mock(Ingredient.class);
        Bun bun = Mockito.mock(Bun.class);
        Mockito.when(ingredient.getType()).thenReturn(ingredientType);
        Mockito.when(ingredient.getName()).thenReturn(ingredientName);
        Mockito.when(bun.getName()).thenReturn(bunName);
        Burger burger = new Burger();
        Burger burgerSpy = Mockito.spy(burger);
        Mockito.doReturn(burgerPrice).when(burgerSpy).getPrice();
        burgerSpy.setBuns(bun);
        for (int i = 0; i < ingredientsNum; i++) {
            burgerSpy.addIngredient(ingredient);
        }
        Assert.assertThat(burgerSpy.getReceipt(), CoreMatchers.startsWith(expectedResult));
    }
}
