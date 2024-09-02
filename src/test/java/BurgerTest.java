import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import java.util.ArrayList;
import java.util.List;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Mock
    Ingredient ingredientFirst;

    @Mock
    Ingredient ingredientSecond;

    @Spy
    Burger burger;
    @Test
    public void setBunTest(){
        Burger burger = new Burger();
        burger.setBuns(bun);
        Assert.assertEquals(burger.bun, bun);
    }

    @Test
    public void addIngredientTest(){
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        Assert.assertEquals(ingredient, burger.ingredients.get(0));
    }
    @Test
    public void getReceiptTest(){
        burger.bun=bun;
        burger.ingredients.add(ingredientFirst);
        burger.ingredients.add(ingredientSecond);
        Mockito.when(bun.getName()).thenReturn("BBQ");
        Mockito.when(ingredientFirst.getType()).thenReturn(SAUCE);
        Mockito.when(ingredientFirst.getName()).thenReturn("QqQQ");
        Mockito.when(ingredientSecond.getType()).thenReturn(FILLING);
        Mockito.when(ingredientSecond.getName()).thenReturn("AqAA");
        Mockito.when(burger.getPrice()).thenReturn(38.8f);
        String expected= "(==== BBQ ====)\n= sauce QqQQ =\n= filling AqAA =\n(==== BBQ ====)\n\nPrice: 38,799999\n";
        Assert.assertEquals(expected,burger.getReceipt());
    }

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


    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        List<Ingredient> expected = new ArrayList<>();
        expected.add(0, ingredientSecond);
        burger.ingredients.add(0, ingredientFirst);
        burger.ingredients.add(1, ingredientSecond);
        burger.removeIngredient(0);
        Assert.assertEquals(expected, burger.ingredients);
    }
    @Test
    public void moveIngredient(){
        Burger burger = new Burger();
        List<Ingredient> expected = new ArrayList<>();
        expected.add(0, ingredientSecond);
        expected.add(1, ingredientFirst);
        burger.ingredients.add(0, ingredientFirst);
        burger.ingredients.add(1,ingredientSecond);
        burger.moveIngredient(1, 0);
        Assert.assertEquals(expected, burger.ingredients);
    }

        }






