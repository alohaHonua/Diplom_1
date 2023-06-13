import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class BurgerPriceTest {

    private final float bunPrice;
    private final float saucePrice;
    private final float fillingPrice;
    private final float expectedSum;

    public BurgerPriceTest(float bunPrice, float saucePrice, float fillingPrice, float expectedSum) {
        this.bunPrice = bunPrice;
        this.saucePrice = saucePrice;
        this.fillingPrice = fillingPrice;
        this.expectedSum = expectedSum;
    }

    @Parameterized.Parameters(name = "Bun: {0}, Sauce: {1}, Filling: {2} -> Expected: {3}")
    public static Object[][] getData() {
        return new Object[][] {
                {100, 30, 50, 280},
                {100, 0, 60, 260},
                {100, 35, 0, 235},
                {145, 0, 0, 290},
        };
    }

    @Mock
    Bun bun;

    @Mock
    Ingredient sauce;

    @Mock
    Ingredient filling;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldCalculateCorrectPrice() {
        Burger burger = new Burger();

        when(bun.getPrice()).thenReturn(bunPrice);
        when(sauce.getPrice()).thenReturn(saucePrice);
        when(filling.getPrice()).thenReturn(fillingPrice);

        burger.setBuns(bun);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);

        float actualSum = burger.getPrice();
        Assert.assertEquals(expectedSum, actualSum, 0.01f);
    }
}