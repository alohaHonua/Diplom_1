package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;

    //стаб для первого ингредиента - Соусы
    public Ingredient getMockSauce() {
        Ingredient ingredientMock = mock(Ingredient.class);
        when(ingredientMock.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredientMock.getName()).thenReturn("hot sauce");
        when(ingredientMock.getPrice()).thenReturn((float) 100);
        return ingredientMock;
    }

    //стаб для второго ингредиента - Начинка
    public Ingredient getMockeFilling() {
        Ingredient ingredientMock = mock(Ingredient.class);
        when(ingredientMock.getType()).thenReturn(IngredientType.FILLING);
        when(ingredientMock.getName()).thenReturn("cutlet");
        when(ingredientMock.getPrice()).thenReturn((float) 100);
        return ingredientMock;
    }

    //стаб для булки
    public Bun getMockBun() {
        Bun bunMock = mock(Bun.class);
        when(bunMock.getName()).thenReturn("black bun");
        when(bunMock.getPrice()).thenReturn((float) 100);
        return bunMock;
    }

    @Test
    public void getReceiptCheckWithMockData() {
        burger = new Burger();
        Bun bunMock = getMockBun();
        Ingredient firstIngredientMock = getMockSauce();
        Ingredient secondIngredientMock = getMockeFilling();
        burger.setBuns(bunMock);
        burger.addIngredient(firstIngredientMock);
        burger.addIngredient(secondIngredientMock);
        String actualReceipt = burger.getReceipt();
        String expectedReceipt = String.format("" +
                "(==== black bun ====)%n" +
                "= sauce hot sauce =%n" +
                "= filling cutlet =%n" +
                "(==== black bun ====)%n" +
                "%n" +
                "Price: 400,000000%n");
        Assert.assertEquals(expectedReceipt, actualReceipt);
    }

    @Test
    public void addIngredientTest() throws Exception {
        Burger burger = new Burger();
        Ingredient firstIngredientMock = getMockSauce();
        Ingredient secondIngredientMock = getMockeFilling();
        burger.addIngredient(firstIngredientMock);
        burger.addIngredient(secondIngredientMock);
        assertEquals(burger.ingredients.size(),2);
    }

    @Test
    public void removeIngredientTest() throws Exception {
        Burger burger = new Burger();
        Ingredient firstIngredientMock = getMockSauce();
        Ingredient secondIngredientMock = getMockeFilling();
        burger.addIngredient(firstIngredientMock);
        burger.addIngredient(secondIngredientMock);
        burger.removeIngredient(0);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() throws Exception {
        Burger burger = new Burger();
        Ingredient firstIngredientMock = getMockSauce();
        Ingredient secondIngredientMock = getMockeFilling();
        burger.addIngredient(firstIngredientMock);
        burger.addIngredient(secondIngredientMock);
        burger.moveIngredient(0, 1);
        assertEquals(2, burger.ingredients.size());
    }

    @Test
    public void getPriceTest() throws Exception {
        assertEquals(getMockBun().getPrice(), 100,0);
    }
}