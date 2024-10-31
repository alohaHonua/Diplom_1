import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Spy
    Burger burger;
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient secondIngredient;
    @Mock
    IngredientType ingredientType;

    @Test
    public void burgersSetBunsMethodTest(){
        burger.setBuns(bun);
        Mockito.verify(burger, Mockito.times(1)).setBuns(bun);
    }
    @Test
    public void burgersAddIngredientMethodTest(){
        burger.addIngredient(ingredient);
        Assert.assertEquals(1, burger.ingredients.size());
    }
    @Test
    public void burgersRemoveIngredientMethodTest(){
        burger.ingredients.add(ingredient);
        burger.ingredients.add(secondIngredient);
        burger.removeIngredient(1);
        Assert.assertEquals(1, burger.ingredients.size());
    }
    @Test
    public void burgersMoveIngredientMethodTest(){
        burger.ingredients.add(ingredient);
        burger.ingredients.add(secondIngredient);
        burger.moveIngredient(1,0);
        Assert.assertEquals(secondIngredient, burger.ingredients.get(0));
    }
    @Test
    public void burgersGetPriceMethodTest(){
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(ingredient.getPrice()).thenReturn(50F);
        burger.ingredients.add(ingredient);
        burger.ingredients.add(ingredient);
        Assert.assertEquals(300F, burger.getPrice(), 0);
    }
    @Test
    public void burgersGetReceiptMethodTest(){
        burger.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn("Булка");
        Mockito.when(ingredient.getName()).thenReturn("Соус");
        Mockito.when(secondIngredient.getName()).thenReturn("Начинка");
        Mockito.when(burger.getPrice()).thenReturn(300F);
        Mockito.when(ingredient.getType()).thenReturn(ingredientType);
        Mockito.when(secondIngredient.getType()).thenReturn(ingredientType);
        burger.ingredients.add(ingredient);
        burger.ingredients.add(secondIngredient);
        String expectedString = "(==== Булка ====)\r\n= ingredienttype Соус =\r\n= ingredienttype Начинка =\r\n(==== Булка ====)\r\n\r\nPrice: 300,000000\r\n";
        Assert.assertEquals(expectedString, burger.getReceipt());
    }
}
