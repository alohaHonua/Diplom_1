import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Spy
    private Burger burger = new Burger();
    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredientOne;
    @Mock
    private Ingredient ingredientTwo;

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        Mockito.verify(burger, Mockito.times(1)).setBuns(bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredientOne);
        assertEquals(burger.ingredients.size(), 1);
        Mockito.verify(burger, Mockito.times(1)).addIngredient(ingredientOne);
    }


    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredientOne);
        burger.removeIngredient(0);
        assertEquals(burger.ingredients.size(), 0);
        Mockito.verify(burger, Mockito.times(1)).removeIngredient(0);
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(ingredientOne);
        burger.addIngredient(ingredientTwo);
        burger.moveIngredient(0, 1);
        assertEquals(burger.ingredients.get(0), ingredientTwo);
        Mockito.verify(burger, Mockito.times(1)).moveIngredient(0, 1);
    }

    @Test
    public void getReceiptTest() {
        String newLine = System.lineSeparator();

        String expectedRecip = ("(====  black bun ====)" + newLine + "= sauce hot sauce =" + newLine + "(====  black bun ====)" + newLine + newLine + "Price: 250.000000" + newLine);
        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(bun.getName()).thenReturn(" black bun");
        Mockito.when(ingredientOne.getPrice()).thenReturn(50F);
        Mockito.when(ingredientOne.getName()).thenReturn("hot sauce");
        Mockito.when(ingredientOne.getType()).thenReturn(IngredientType.SAUCE);
        burger.addIngredient(ingredientOne);
        burger.setBuns(bun);

        assertEquals(expectedRecip, burger.getReceipt());
    }
}




