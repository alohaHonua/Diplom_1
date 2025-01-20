import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;



public class BurgerParametrizedTest {
    private Ingredient filling;
    private Ingredient sauce;
    private Burger burger;

    @Before
    public void setUp() {
        filling = Mockito.mock(Ingredient.class);
        sauce = Mockito.mock(Ingredient.class);
        Mockito.when(filling.getPrice()).thenReturn(300f);
        Mockito.when(sauce.getPrice()).thenReturn(200f);

        burger = new Burger();
    }

    @Test
    public void testGetPriceWithToastedBun() {
        float priceBun = 100f;
        String nameBun = "toastedBun";
        Bun bun = Mockito.mock(Bun.class);

        Mockito.when(bun.getName()).thenReturn(nameBun);
        Mockito.when(bun.getPrice()).thenReturn(priceBun);
        burger.setBuns(bun);

        burger.addIngredient(sauce);
        burger.addIngredient(filling);

        float expectedPrice = priceBun * 2 + filling.getPrice() + sauce.getPrice();
        float actualPrice = burger.getPrice();

        Assert.assertEquals(expectedPrice, actualPrice, 0);
    }

    @Test
    public void testGetPriceWithGiftBun() {
        float priceBun = 0f;
        String nameBun = "giftBun";
        Bun bun = Mockito.mock(Bun.class);

        Mockito.when(bun.getName()).thenReturn(nameBun);
        Mockito.when(bun.getPrice()).thenReturn(priceBun);
        burger.setBuns(bun);

        burger.addIngredient(sauce);
        burger.addIngredient(filling);

        float expectedPrice = priceBun * 2 + filling.getPrice() + sauce.getPrice();
        float actualPrice = burger.getPrice();

        Assert.assertEquals(expectedPrice, actualPrice, 0);
    }
}
