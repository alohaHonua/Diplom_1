import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bunMock;

    @Mock
    Ingredient ingredientMock;

    @Test
    public void setBunTest(){
        Burger burger = new Burger();
        burger.setBuns(bunMock);
        Assert.assertEquals(bunMock, burger.bun);
    }
    @Test
    public void addIngredientTest(){
        Burger burger = new Burger();
        burger.addIngredient(ingredientMock);
        Assert.assertTrue(burger.ingredients.contains(ingredientMock));
    }
    @Test
    public void removeIngredientTest(){
        Burger burger = new Burger();
        burger.addIngredient(ingredientMock);
        burger.removeIngredient(0);
        Assert.assertFalse(burger.ingredients.contains(ingredientMock));
    }
    @Test
    public void moveIngredientTest(){
        Burger burger = new Burger();
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "Соус фирменный Space Sauce",80));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "Биокотлета из марсианской Магнолии", 424));
        burger.moveIngredient(0,1);
        Assert.assertEquals("Биокотлета из марсианской Магнолии", burger.ingredients.get(0).name);

    }
    @Test
    public void getPriceTest(){
        Burger burger = new Burger();
        float price = 1313;
        Mockito.when(bunMock.getPrice()).thenReturn(price);
        Mockito.when(ingredientMock.getPrice()).thenReturn(price);
        burger.setBuns(bunMock);
        burger.addIngredient(ingredientMock);
        Assert.assertEquals(price * 2 + price, burger.getPrice(), 0);
    }
    @Test
    public void getReceiptBurgerTest() {
        Burger burger = new Burger();
        burger.setBuns(bunMock);
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "Биокотлета из марсианской Магнолии", 424));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "Соус фирменный Space Sauce",80));
        String expectedReceipt = burger.getReceipt();
        Assert.assertEquals(expectedReceipt, burger.getReceipt());
    }
}
