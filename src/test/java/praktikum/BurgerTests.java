package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static praktikum.IngredientType.SAUCE;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTests {

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Test
    public void checkBurgerGetPrice() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(10F);
        Mockito.when(ingredient.getPrice()).thenReturn(25F);
        float burgerPrice = 45F;
        Assert.assertEquals(burgerPrice, burger.getPrice(),0);
    }

    @Test
    public void checkBurgerGetReceipt() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn("Bun");
        Mockito.when(ingredient.getName()).thenReturn("ingredient");
        Mockito.when(ingredient.getType()).thenReturn(SAUCE);
        Mockito.when(burger.getPrice()).thenReturn(25F);
        String burgerReceipt = String.format("(==== Bun ====)%n= sauce ingredient =%n(==== Bun ====)%n%nPrice: %f%n", burger.getPrice());
        Assert.assertEquals(burgerReceipt, burger.getReceipt());
    }
}