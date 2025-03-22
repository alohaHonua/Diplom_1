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

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Burger burger = new Burger();

    @Mock
    Bun bun;

    @Test
    public void setBunsToBurger(){
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
    }

    @Mock
    Ingredient firstIngredient, secondIngrediet;

    @Test
    public void addIngredientsToBurger(){
        burger.addIngredient(firstIngredient);
        Assert.assertEquals(firstIngredient, burger.ingredients.get(0));
    }

    @Test
    public void removeIngredientsFromBurger(){
        burger.addIngredient(firstIngredient);
        burger.removeIngredient(0);
        Assert.assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientsFromBurger(){
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngrediet);
        int expectedIndex = 1;
        burger.moveIngredient(0, 1);
        Assert.assertEquals(expectedIndex, burger.ingredients.lastIndexOf(firstIngredient));
    }

    @Test
    public void returnCorrectPrice(){
        burger.setBuns(bun);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngrediet);
        int expectedPrice = 2949;
        Mockito.when(bun.getPrice()).thenReturn(1255.00F);
        Mockito.when(firstIngredient.getPrice()).thenReturn(15.00F);
        Mockito.when(secondIngrediet.getPrice()).thenReturn(424.00F);
        Assert.assertEquals(expectedPrice, burger.getPrice(),0);
    }

    @Test
    public void returnCorrectReceipt(){
        burger.setBuns(bun);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngrediet);
        String expectedReceipt = "(==== Краторная булка N-200i ====)\n= sauce Соус традиционный галактический =\n= filling Биокотлета из марсианской Магнолии =\n(==== Краторная булка N-200i ====)\n\nPrice: 2949.000000\n";
        Mockito.when(bun.getName()).thenReturn("Краторная булка N-200i");
        Mockito.when(bun.getPrice()).thenReturn(1255.00F);
        Mockito.when(firstIngredient.getName()).thenReturn("Соус традиционный галактический");
        Mockito.when(firstIngredient.getPrice()).thenReturn(15.00F);
        Mockito.when(firstIngredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(secondIngrediet.getName()).thenReturn("Биокотлета из марсианской Магнолии");
        Mockito.when(secondIngrediet.getPrice()).thenReturn(424.00F);
        Mockito.when(secondIngrediet.getType()).thenReturn(IngredientType.FILLING);
        Assert.assertEquals(expectedReceipt, burger.getReceipt());
    }
}