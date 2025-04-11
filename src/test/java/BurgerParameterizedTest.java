import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;

import org.mockito.Mockito;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class BurgerParameterizedTest extends BurgerBaseTest {
    private final String bunName;
    private final float bunPrice;
    private final IngredientType ingredient1Type;
    private final String ingredient1Name;
    private final float ingredient1Price;
    private final IngredientType ingredient2Type;
    private final String ingredient2Name;
    private final float ingredient2Price;

    public BurgerParameterizedTest(String bunName, float bunPrice,
                                   IngredientType ingredient1Type, String ingredient1Name, float ingredient1Price,
                                   IngredientType ingredient2Type, String ingredient2Name, float ingredient2Price) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
        this.ingredient1Type = ingredient1Type;
        this.ingredient1Name = ingredient1Name;
        this.ingredient1Price = ingredient1Price;
        this.ingredient2Type = ingredient2Type;
        this.ingredient2Name = ingredient2Name;
        this.ingredient2Price = ingredient2Price;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Белая булка", 100f, IngredientType.FILLING, "Котлета", 150f, IngredientType.SAUCE, "Горчица", 50f},
                {"Черная булка", 150f, IngredientType.FILLING, "Сыр", 200f, IngredientType.SAUCE, "Кетчуп", 30f},
                {"Ржаная булка", 120f, IngredientType.FILLING, "Бекон", 180f, IngredientType.SAUCE, "Майонез", 40f}
        });
    }

    @Override
    @Before
    public void setUp() {
        super.setUp();
        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient1.getType()).thenReturn(ingredient1Type);
        Mockito.when(ingredient1.getName()).thenReturn(ingredient1Name);
        Mockito.when(ingredient1.getPrice()).thenReturn(ingredient1Price);
        Mockito.when(ingredient2.getType()).thenReturn(ingredient2Type);
        Mockito.when(ingredient2.getName()).thenReturn(ingredient2Name);
        Mockito.when(ingredient2.getPrice()).thenReturn(ingredient2Price);
    }

    @Test
    public void testGetPrice() {
        burger.bun = bun;
        burger.ingredients = Arrays.asList(ingredient1, ingredient2);
        float expectedPrice = bunPrice * 2 + ingredient1Price + ingredient2Price;
        assertEquals(expectedPrice, burger.getPrice(), 0.0f);
    }

    @Test
    public void testGetReceipt() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        String expectedReceipt = String.format(
                "(==== %s ====)%n= %s %s =%n= %s %s =%n(==== %s ====)%n%nPrice: %f%n",
                bunName,
                ingredient1Type.toString().toLowerCase(), ingredient1Name,
                ingredient2Type.toString().toLowerCase(), ingredient2Name,
                bunName,
                bunPrice * 2 + ingredient1Price + ingredient2Price);

        assertEquals(expectedReceipt, burger.getReceipt());
    }
}