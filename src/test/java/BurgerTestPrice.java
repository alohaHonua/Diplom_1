import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

public class BurgerTestPrice {
    @Mock
    Ingredient ingredientFirst;

    @Mock
        Bun bun;
    @Mock
    Ingredient ingredientSecond;

    @Test
    public void getpriceTest(){
        Burger burger = new Burger();
        burger.bun = bun;
        burger.ingredients.add(ingredientFirst);
        burger.ingredients.add(ingredientSecond);
        Mockito.when(bun.getPrice()).thenReturn(11.1f);
        Mockito.when(ingredientFirst.getPrice()).thenReturn(5.5f);
        Mockito.when(ingredientSecond.getPrice()).thenReturn(22.2f);
        Float expected = 49.9f;
        Assert.assertEquals(expected, burger.getPrice(), 0);
    }
}
