import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class BurgerParameterizedTest {

    private String BunName = "Бриошь";

    private final String nameIngredient;
    private final IngredientType type;

    private final String expectedResult;

    private Integer count = 0;

    public BurgerParameterizedTest(String nameIngredient, IngredientType type, String expectedResult, Integer count) {
        this.nameIngredient = nameIngredient;
        this.type = type;
        this.expectedResult = expectedResult;
        this.count = count;
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }


    @Mock
    Bun bun;

    @Spy
    private Ingredient ingredient = new Ingredient(SAUCE, "Томат", 2F);

    @Parameterized.Parameters
    public static Object[] getBody() {
        return new Object[][]{
                {"Колбаса", FILLING, "(==== Бриошь ====)\n" +
                        "(==== Бриошь ====)\n" +
                        "\n" +
                        "Price: 4,000000\n", 0},{"Колбаса", FILLING, "(==== Бриошь ====)\n" +
                "= filling Колбаса =\n" +
                "(==== Бриошь ====)\n" +
                "\n" +
                "Price: 6,000000\n", 1}, {"Колбаса", FILLING, "(==== Бриошь ====)\n" +
                "= filling Колбаса =\n" +
                "= filling Колбаса =\n" +
                "(==== Бриошь ====)\n" +
                "\n" +
                "Price: 8,000000\n", 2},


        };
    }

    @Test
    public void getReceiptBurgerTest() {
        Mockito.when(bun.getName()).thenReturn(BunName);
        Mockito.when(bun.getPrice()).thenReturn(2F);
        Mockito.when(ingredient.getType()).thenReturn(type);
        Mockito.when(ingredient.getName()).thenReturn(nameIngredient);

        Burger burger = new Burger();
        burger.setBuns(bun);
        if (count != 0) {
            for (Integer i = 0; i < count; i++) {
                burger.addIngredient(ingredient);
            }
        }
        Assert.assertEquals(expectedResult, burger.getReceipt());
    }

}
