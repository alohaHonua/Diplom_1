import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TestBurgerMock {

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredients;
    @Spy
    Burger burger;

    @Test
    public void testGetBun(){
        burger.setBuns(bun);
        Mockito.verify(burger, Mockito.times(1)).setBuns(bun);
    }

    @Test
    public void testAddIngredient(){
        burger.addIngredient(ingredients);
        Mockito.verify(burger, Mockito.times(1)).addIngredient(ingredients);
    }

    @Test
    public void testRemoveIngredients(){
        BaseObjectBurger baseObjectBurger = new BaseObjectBurger();
        baseObjectBurger.getIndexListFromAddRemoveIngredient(burger, 1);
        //добавили в список данные
        //хранящиеся под 1 индексом в БД
        burger.removeIngredient(0);//и сразу удалили. Индекс 0, так как пока
        //в списке только один список с 0ым индексом
        Mockito.verify(burger, Mockito.times(1)).removeIngredient(0);
    }
    @Test
    public void testMoveIngredient(){
        BaseObjectBurger baseObjectBurger = new BaseObjectBurger();
        List<Integer> result = baseObjectBurger.getIndexListFromMoveIngredient(burger, 1, 0, 0);
        int index = result.get(0);//вытянули из переменной result возвращаемое методом getIndexListFromMoveIngredient
        int newIndex = result.get(1);//тоже вытянули значение переменной result выданное методом getIndexListFromMoveIngredient
        Mockito.verify(burger, Mockito.times(1)).moveIngredient(index, newIndex);
    }

    @Test
    public void testGetPrice(){
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(200.F);
        //Mockito.when(ingredients.getPrice()).thenReturn(600.0F);
        burger.getPrice();
        Mockito.verify(burger, Mockito.times(1)).getPrice();
    }

    @Test
    public void testGetReceipt(){
        burger.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn("булка");
//        Mockito.when(ingredients.getName()).thenReturn("салатовый лист");
//        Mockito.when(ingredients.getType()).thenReturn(IngredientType.valueOf("SAUCE"));
        burger.getReceipt();
        Mockito.verify(burger, Mockito.times(1)).getReceipt();
    }


}
