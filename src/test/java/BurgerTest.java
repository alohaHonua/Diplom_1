import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;


import java.util.List;

@RunWith(MockitoJUnitRunner.class)

public class BurgerTest {

    private static final String BUN_NAME = "black bun";
    private static final float BUN_PRICE = 1.9f;
    private static final float DELTA = 0000.1f;

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    @Test
    public void setBunTest() {
        Mockito.when(bun.getName()).thenReturn(BUN_NAME);
        Mockito.when(bun.getPrice()).thenReturn(BUN_PRICE);
        Burger burger = new Burger();
        burger.setBuns(bun);
        Assert.assertEquals(BUN_NAME, bun.getName());
        Assert.assertEquals(BUN_PRICE, bun.getPrice(), DELTA);
        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        Burger burger = new Burger();
        List<Ingredient> ingredients = burger.ingredients;
        burger.addIngredient(ingredient);
        Assert.assertEquals(1, ingredients.size());
        Assert.assertEquals(ingredient, ingredients.get(0));
    }
}
