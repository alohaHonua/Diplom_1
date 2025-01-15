import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)

public class BurgerParametrizedTest {
    private final float priceBun;
    private Ingredient filling;
    private Ingredient sauce;
    private Burger burger;
    private final String nameBun;

    public BurgerParametrizedTest(float price, String name) {
        this.priceBun = price;
        this.nameBun = name;
    }

    @Before
    public void setUp() {
        filling = new Ingredient(IngredientType.FILLING, "sausage", 300);
        sauce = new Ingredient(IngredientType.SAUCE, "cream", 200);
        burger = new Burger();
    }

    @Parameterized.Parameters
    public static Object [] [] getBunInfo() {
        return new Object[][] {
                {100, "toastedBun"},
                {0, "giftBun"}  //бесплатная булочка
        };

    }

    @Test
    public void getPrice() {
        Bun bun = new Bun(nameBun, priceBun);
        burger.setBuns(bun);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        float expectedPrice = bun.price * 2 + filling.price + sauce.price;
        float actualPrice = burger.getPrice();
        Assert.assertEquals(expectedPrice, actualPrice, 0);
    }

}
