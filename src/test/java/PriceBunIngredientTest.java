
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class PriceBunIngredientTest {
    private static final String BUN_NAME = "Флюоресцентная булка R2-D3";
    private static final String FILLING_NAME = "Мясо бессмертных моллюсков Protostomia";
    private static final IngredientType INGREDIENT_TYPE = IngredientType.FILLING;

    private Bun bun;
    private Ingredient ingredient;
    private float price;

    @Before
    public void init() {
        bun = new Bun(BUN_NAME, price);
        ingredient = new Ingredient(INGREDIENT_TYPE, FILLING_NAME, price);
    }

    public PriceBunIngredientTest( double price) {
        this.price = (float) price;
    }

    @Parameterized.Parameters(name = " price ({0})")
    public static Object[][] setParams() {
        return new Object[][]{
                {250},
                {3050.84},
                {999999999},
                {0},
                {-3050.84},
        };
    }

    @Test
    public void getPriceBunTest() {
        Assert.assertEquals("Цена булки возвращается не верно"
                , Float.valueOf(price), bun.getPrice(),0);
    }

    @Test
    public void priceIngredientTest() {
        Assert.assertEquals("Цена инградиента возвращается не верно"
                , Float.valueOf(price), ingredient.getPrice(),0);
    }

}

