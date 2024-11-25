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
public class BurgerGetReceiptParametrizedTest {
    private final IngredientType INGREDIENT_TYPE;
    private final String INGREDIENT_NAME;
    private final int INGREDIENTS_NUM;
    private final String BUN_NAME;
    private final float BURGER_PRICE;
    private final String EXPECTED_RESULT;

    public BurgerGetReceiptParametrizedTest(IngredientType INGREDIENT_TYPE, String INGREDIENT_NAME, int INGREDIENTS_NUM, String BUN_NAME, float BURGER_PRICE, String EXPECTED_RESULT) {
        this.INGREDIENT_TYPE = INGREDIENT_TYPE;
        this.INGREDIENT_NAME = INGREDIENT_NAME;
        this.INGREDIENTS_NUM = INGREDIENTS_NUM;
        this.BUN_NAME = BUN_NAME;
        this.BURGER_PRICE = BURGER_PRICE;
        this.EXPECTED_RESULT = EXPECTED_RESULT;
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
        Mockito.when(ingredient.getType()).thenReturn(INGREDIENT_TYPE);
        Mockito.when(ingredient.getName()).thenReturn(INGREDIENT_NAME);
        Mockito.when(bun.getName()).thenReturn(BUN_NAME);
        Burger burger = new Burger();
        Burger burgerSpy = Mockito.spy(burger);
        Mockito.doReturn(BURGER_PRICE).when(burgerSpy).getPrice();
        burgerSpy.setBuns(bun);
        for (int i = 0; i < INGREDIENTS_NUM; i++) {
            burgerSpy.addIngredient(ingredient);
        }
        Assert.assertThat(burgerSpy.getReceipt(), CoreMatchers.startsWith(EXPECTED_RESULT));
    }
}
