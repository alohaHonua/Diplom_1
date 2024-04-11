package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;
    private Bun mockBun;
    private Ingredient mockIngredient;

    @Before
    public void setUp() {
        burger = new Burger();
        mockBun = mock(Bun.class);
        mockIngredient = mock(Ingredient.class);

        burger.setBuns(mockBun);
        burger.ingredients.add(mockIngredient);
        burger.ingredients.add(mockIngredient);
    }

    @Test
    public void checkRemoveBurgerIngredient() {
        burger.removeIngredient(0);
        Assert.assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void checkAddBurgerIngredient() {
        burger.addIngredient(mockIngredient);
        Assert.assertEquals(3, burger.ingredients.size());
    }

    @Test
    public void checkMoveBurgerIngredient() {
        Ingredient anotherMockIngredient = mock(Ingredient.class);
        burger.ingredients.add(anotherMockIngredient);
        burger.moveIngredient(1, 2);
        Assert.assertEquals(anotherMockIngredient, burger.ingredients.get(1));
        Assert.assertEquals(mockIngredient, burger.ingredients.get(2));
    }

    @Test
    public void checkGetBurgerPrice() {
        when(mockBun.getPrice()).thenReturn(100F);
        when(mockIngredient.getPrice()).thenReturn(200F);
        Assert.assertEquals(600F, burger.getPrice(), 0.001);
    }

    @Test
    public void checkGetBurgerReceipt() {
        when(mockBun.getName()).thenReturn("red bun");
        when(mockIngredient.getType()).thenReturn(SAUCE);
        when(mockIngredient.getName()).thenReturn("sausage");
        when(mockIngredient.getPrice()).thenReturn(1.0f);

        String expectedReceipt = "(==== red bun ====)\n" +
                "= sauce sausage =\n" +
                "= sauce sausage =\n" +
                "(==== red bun ====)\n" +
                "\n" +
                "Price: 2,000000\n";

        Assert.assertEquals(expectedReceipt, burger.getReceipt());
    }
}
