package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    private Bun bun;
    @Mock
    private Ingredient firstIngredient;
    @Mock
    private Ingredient secondIngredient;

    @Spy
    private Burger burger;

    @Test
    public void setBunTest() {
        burger.setBuns(bun);
        Assert.assertEquals("Не та булочка",
                bun,
                burger.bun);
    }

    @Test
    public void addIngredientTest() {
        List<Ingredient> expected = new ArrayList<>();
        expected.add(firstIngredient);
        burger.addIngredient(firstIngredient);
        Assert.assertEquals(
                "Не тот ингредиент",
                expected,
                burger.ingredients);
    }

    @Test
    public void removeIngredientTest() {
        List<Ingredient> expected = new ArrayList<>();
        expected.add(secondIngredient);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.removeIngredient(0);
        Assert.assertEquals(
                "Ингредиент не был удален",
                expected,
                burger.ingredients);
    }

    @Test
    public void moveIngredientTest() {
        List<Ingredient> expected = new ArrayList<>();
        expected.add(secondIngredient);
        expected.add(firstIngredient);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.moveIngredient(1, 0);
        Assert.assertEquals(
                "Ингредиент не был перемещен",
                expected,
                burger.ingredients);
    }

    @Test
    public void getReceiptSpyTest() {
        burger.setBuns(bun);
        burger.getReceipt();
        Mockito.verify(burger, Mockito.times(1)).getPrice();
    }
}
