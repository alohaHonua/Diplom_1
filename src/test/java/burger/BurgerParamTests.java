package burger;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class BurgerParamTests {
    private Float bunPrice;
    private Float ingredientPrice;
    private Float expectedPrice;
    private Burger burger;
    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient;
    public BurgerParamTests(Float bunPrice, Float ingredientPrice, Float expectedPrice) {
        this.bunPrice = bunPrice;
        this.ingredientPrice = ingredientPrice;
        this.expectedPrice = expectedPrice;
    }
    @Parameterized.Parameters
    public static Collection<Object[]> getTestData() {
        return Arrays.asList(new Object[][] {
                {100f, 100f, 300f},
                {200f, 200f, 600f},
                {300f, 300f, 900f}
        });
    }
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        burger = new Burger();
    }
    @Test
    public void getPrice() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        when(bun.getPrice()).thenReturn(bunPrice);
        when(ingredient.getPrice()).thenReturn(ingredientPrice);
        Float burgerPrice = burger.getPrice();

        assertEquals(burgerPrice, expectedPrice);
    }
}