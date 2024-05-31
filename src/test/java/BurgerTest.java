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

import java.util.ArrayList;

import static org.mockito.Mockito.when;
import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock private Ingredient ingredient;
    @Spy private Burger burger = new Burger();
    @Mock private Bun bun;

    @Test
    public void setBunsTest(){
        burger.setBuns(bun);
        Mockito.verify(burger, Mockito.times(1)).setBuns(bun);
    }

    @Test
    public void getReceiptTest(){
        when(bun.getName()).thenReturn("SomeName");
        when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        when(ingredient.getName()).thenReturn("Some123");
        when(ingredient.getPrice()).thenReturn((float) 1);
        burger.setBuns(bun);
        burger.ingredients.add(ingredient);
        burger.ingredients.add(ingredient);
        burger.getReceipt();
        Mockito.verify(burger,Mockito.times(1)).getReceipt();
        System.out.println(burger.getReceipt());
    }

    @Test
    public void addIngredientTest(){
        burger.ingredients =  new ArrayList<>();
        burger.addIngredient(ingredient);
        assertEquals(burger.ingredients.size(),1,0);
    }

    @Test
    public void removeIngredientTest(){
        burger.ingredients =  new ArrayList<>();
        burger.ingredients.add(ingredient);
        burger.removeIngredient(0);
        Mockito.verify(burger).removeIngredient(Mockito.anyInt());
        assertEquals(burger.ingredients.size(),0,0);
    }

    @Test
    public void moveIngredientTest(){
        burger.ingredients =  new ArrayList<>();
        burger.ingredients.add(ingredient);
        burger.ingredients.add(ingredient);
        burger.moveIngredient(0,1);
        Mockito.verify(burger,Mockito.times(1)).moveIngredient(0,1);
        assertEquals(burger.ingredients.size(),2,0);
    }

    @Test
    public void getPriceTest(){
        when(bun.getPrice()).thenReturn((float) 1);
        burger.setBuns(bun);
        assert(burger.getPrice()==2.0);
        Mockito.verify(burger,Mockito.times(1)).getPrice();
    }

}
