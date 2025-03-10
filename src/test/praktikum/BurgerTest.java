package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger = new Burger();
    String expected = null;
    int sizeIngredient=0;

    @Mock
    Bun bunMock;
    @Mock
    Ingredient ingredientMock;
    @Mock
    Ingredient sauceMock;
    //Burger burger = new Burger();

    @Test
    public void setBunsTest() {
        burger.setBuns(bunMock);
        burger.bun.getName();
        Mockito.verify(bunMock).getName();
        // Mockito.when(burger.bun.getName()).thenReturn("TestBun");
        // Assert.assertEquals("TestBun",burger.bun.getName());
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredientMock);
        burger.ingredients.get(0).getName();
        Mockito.verify(ingredientMock).getName();
        sizeIngredient = burger.ingredients.size();
       // Assert.assertEquals(expected, burger.ingredients.get(0).getName());
        Assert.assertEquals (1, sizeIngredient);
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredientMock);
        burger.addIngredient(sauceMock);
        burger.removeIngredient(0);
        burger.ingredients.get(0).getName();
        Mockito.verify(sauceMock).getName();
        sizeIngredient = burger.ingredients.size();
        Assert.assertEquals (1, sizeIngredient);
        //Assert.assertEquals(expected, burger.ingredients.get(0).getName());
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(ingredientMock);
        burger.addIngredient(sauceMock);
        burger.moveIngredient(0,1);
        burger.ingredients.get(0).getName();
        Mockito.verify(sauceMock).getName();
        sizeIngredient = burger.ingredients.size();
        Assert.assertEquals (2, sizeIngredient);
        //Assert.assertEquals(expected, burger.ingredients.get(0).getName());
    }

    @Test
    public void getReceipt() {
        burger.setBuns(bunMock);
        burger.addIngredient(ingredientMock);
        burger.addIngredient(sauceMock);
        Mockito.when(bunMock.getName()).thenReturn("bun");
        Mockito.when(bunMock.getPrice()).thenReturn(0.23F);
        Mockito.when(ingredientMock.getName()).thenReturn("Cheese");
        Mockito.when(ingredientMock.getPrice()).thenReturn(0.1F);
        Mockito.when(ingredientMock.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(sauceMock.getName()).thenReturn("chili");
        Mockito.when(sauceMock.getPrice()).thenReturn(0.02F);
        Mockito.when(sauceMock.getType()).thenReturn(IngredientType.SAUCE);

        String actual = burger.getReceipt();
        Mockito.verify(bunMock, Mockito.times(2)).getName();
        Mockito.verify(ingredientMock).getName();
        Mockito.verify(ingredientMock).getType();
        Mockito.verify(sauceMock).getName();
        Mockito.verify(sauceMock).getType();
        sizeIngredient = burger.ingredients.size();
        Assert.assertEquals (2, sizeIngredient);
        Assert.assertEquals(IngredientType.FILLING, ingredientMock.getType());
        Assert.assertEquals("chili", sauceMock.getName());
        Assert.assertEquals(IngredientType.SAUCE, sauceMock.getType());
        String expected = String.format("(==== bun ====)%n" +
                "= filling Cheese =%n" +
                "= sauce chili =%n" +
                "(==== bun ====)%n" +
                "%n" +
                "Price: 0,580000%n");
        Assert.assertEquals(expected, actual);
    }

}
