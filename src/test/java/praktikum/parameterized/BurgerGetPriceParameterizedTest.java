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

import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(Parameterized.class)
public class BurgerGetPriceParameterizedTest {

    @Mock private Bun bun;
    @Mock private Ingredient ingredient;

    private final float bunPrice;
    private final float ingredientPrice;
    private final float expected;

    public BurgerGetPriceParameterizedTest(float bunPrice, float ingredientPrice, float expected) {
        this.bunPrice = bunPrice;
        this.ingredientPrice = ingredientPrice;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][]{
                {10, 10, 30},
                //Частный случай, если список ингредиентов пуст
                {10, 0, 20},
        };
    }

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void getPriceTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        if (ingredientPrice != 0 ) {
            burger.addIngredient(ingredient);
            Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);
        }
        float actual = burger.getPrice();
        Assert.assertEquals(
                "Цена посчиталась неправильно",
                expected,
                actual,
                0.01);
    }
}