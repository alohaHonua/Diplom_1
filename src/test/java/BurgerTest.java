import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Spy
    Burger burger;
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient ingredientTest;

    @Test
    public void setBunsTest() {
        Burger burger = Mockito.mock(Burger.class);

        burger.setBuns(bun);

        Mockito.verify(burger, times(1)).setBuns(bun);
    }

    @Test
    public void addIngredientTest() {
        Assert.assertEquals(0, burger.ingredients.size());
        burger.addIngredient(ingredient);

        Assert.assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {

        burger.addIngredient(ingredient);
        burger.removeIngredient(0);

        Assert.assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredientTest);

        burger.moveIngredient(1, 0);

        Assert.assertEquals(1, burger.ingredients.indexOf(ingredient));
        Assert.assertEquals(0, burger.ingredients.indexOf(ingredientTest));
    }

    @Test
    public void getPriceTest() {
        Mockito.when(bun.getPrice()).thenReturn(10F);
        Mockito.when(ingredient.getPrice()).thenReturn(30F);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Float expected = 50F;
        Float actual = burger.getPrice();

        Mockito.verify(bun, times(1)).getPrice();
        Mockito.verify(ingredient, times(1)).getPrice();
        Assert.assertEquals(expected, actual, 0);
    }

    @Test
    public void getReceiptTest() {
        Mockito.when(bun.getName()).thenReturn("Bun");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("TEST");
        Mockito.when(bun.getPrice()).thenReturn(10F);
        Mockito.when(ingredient.getPrice()).thenReturn(30F);

        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        String expected = String.format("(==== Bun ====)%n" +
                "= sauce TEST =%n" +
                "(==== Bun ====)%n" +
                "%n" +
                "Price: 50,000000%n");;
        String actual = burger.getReceipt();

        Mockito.verify(bun, times(2)).getName();
        Mockito.verify(ingredient, times(1)).getType();
        Mockito.verify(ingredient, times(1)).getName();
        Mockito.verify(burger, times(1)).getPrice();

        Assert.assertEquals(expected,actual);
    }

}
