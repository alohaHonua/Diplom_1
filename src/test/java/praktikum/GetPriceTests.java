package praktikum;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

@RunWith(Parameterized.class)
public class GetPriceTests {
    Bun bun;
    Ingredient ingredient;
    Burger newBurger;
    private final float bunPrice;
    private final float ingredientPrice;
    private final int ingredientSize;

    public GetPriceTests(float bunPrice, float ingredientPrice, int ingredientSize) {
        this.bunPrice = bunPrice;
        this.ingredientPrice = ingredientPrice;
        this.ingredientSize = ingredientSize;
    }

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
        bun = Mockito.mock(Bun.class);
        ingredient = Mockito.mock(Ingredient.class);
        newBurger = new Burger();
    }

    @Parameterized.Parameters
    public static Object[][] price() {
        return new Object[][]{
                {12.95f, 22.25f, 1},
                {18.50f, 25.85f, 2},
                {15.90f, 0.0f,   0},
        };
    }

    @Test
    public void getPriceTest() {
        float price = (bunPrice * 2) + (ingredientPrice * ingredientSize);
        newBurger.setBuns(bun);
        for (int i = 1; i <= ingredientSize; i++) {
            newBurger.addIngredient(ingredient);
        }
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);
        float result = newBurger.getPrice();
        Assert.assertEquals(price, result, 0);
    }
}
