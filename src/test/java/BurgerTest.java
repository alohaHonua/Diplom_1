import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)

public class BurgerTest {

    @Mock
    Burger burger;

    @Mock
    Ingredient ingredient;

    @Mock
    Ingredient sauce ;

    @Mock
    Ingredient filling;

    @Mock
    Bun bun;


    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBunsInBurger() {
        burger.setBuns(bun);
        Bun actualBunInBurger = burger.bun;
        Assert.assertEquals(bun, actualBunInBurger );

    }

    @Test
    public void addIngredientInBurger () {
        burger.addIngredient(ingredient);
        List<Ingredient> actualIngredientInBurger = burger.ingredients;
        List<Ingredient> expectIngredientInBurger = List.of(ingredient);
        Assert.assertEquals(expectIngredientInBurger, actualIngredientInBurger);
    }

    @Test
    public void removeIngredientFromBurger () {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        List<Ingredient> actualIngredientInBurger = burger.ingredients;
        Assert.assertEquals(List.of(), actualIngredientInBurger);

    }

    @Test
    public void moveIngredient () {
        burger.addIngredient(filling);
        burger.addIngredient(sauce);
        burger.moveIngredient(0, 1);
        Ingredient actualPosition = burger.ingredients.get(1);
        Assert.assertEquals(filling, actualPosition);
    }

    @Test
    public void getReceipt() {

        Mockito.when(bun.getName()).thenReturn("toastedBun");
        Mockito.when(bun.getPrice()).thenReturn(5.0f);

        Mockito.when(filling.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(filling.getName()).thenReturn("sausage");
        Mockito.when(filling.getPrice()).thenReturn(10.0f);

        Mockito.when(sauce.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(sauce.getName()).thenReturn("cream");
        Mockito.when(sauce.getPrice()).thenReturn(15.0f);

        burger.setBuns(bun);
        burger.addIngredient(filling);
        burger.addIngredient(sauce);

        String expectedReceipt = String.format("(==== %s ====)%n", "toastedBun") +
                String.format("= %s %s =%n", "filling", "sausage") +
                String.format("= %s %s =%n", "sauce", "cream") +
                String.format("(==== %s ====)%n", "toastedBun") +
                String.format("%nPrice: %f%n", 35.0f);


        String actualReceipt = burger.getReceipt();
        Assert.assertEquals(expectedReceipt, actualReceipt);


    }

}
