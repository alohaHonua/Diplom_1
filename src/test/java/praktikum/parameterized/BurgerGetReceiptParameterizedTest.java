package praktikum.parameterized;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(Parameterized.class)
public class BurgerGetReceiptParameterizedTest {

    @Mock private Bun bun;
    @Mock private Ingredient ingredient;

    private final String bunName;
    private final float bunPrice;
    private final String ingredientName;
    private final float ingredientPrice;
    private final IngredientType ingredientType;
    private final String expected;

    public BurgerGetReceiptParameterizedTest(String bunName,
                                             float bunPrice,
                                             String ingredientName,
                                             float ingredientPrice,
                                             IngredientType ingredientType,
                                             String expected) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
        this.ingredientName = ingredientName;
        this.ingredientPrice = ingredientPrice;
        this.ingredientType = ingredientType;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][]{
                {
                    "bunName",
                        10,
                        "ingredientName",
                        5,
                        IngredientType.FILLING,
                        String.format("(==== bunName ====)%n" +
                                "= filling ingredientName =%n" +
                                "(==== bunName ====)%n" +
                                "%n" +
                                "Price: 25,000000%n")
                },
                //Частный случай, если список ингредиентов пуст
                {
                    "bunName",
                        10,
                        null,
                        0,
                        null,
                        String.format("(==== bunName ====)%n" +
                                "(==== bunName ====)%n" +
                                "%n" +
                                "Price: 20,000000%n")
                }
        };
    }

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void getReceiptTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        if (ingredientPrice != 0 ) {
            burger.addIngredient(ingredient);
            Mockito.when(ingredient.getName()).thenReturn(ingredientName);
            Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);
            Mockito.when(ingredient.getType()).thenReturn(ingredientType);
        }
        String actual = burger.getReceipt();
        System.out.println(actual);
        Assert.assertEquals(
                "Получен неправильный рецепт",
                expected,
                actual);
    }
}
