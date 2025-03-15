import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTests {

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient;

    @Mock
    private Database database;

    @Test
    public void setBunTestReturnName() {
        //Этим тестом я проверяю корректную работу метода setBuns в классе Burger, если булка установилась можно вернуть её название
        String testValue = "Название булочки";
        Mockito.when(bun.getName()).thenReturn(testValue);
        Burger burger = new Burger();
        burger.setBuns(bun);
        String result = burger.bun.getName();
        assertEquals(testValue, result);
    }

    @Test
    public void setBunTestReturnPrice(){
        //Этим тестом я проверяю корректную работу метода setBuns в классе Burger, если булка установилась можно вернуть её цену
        float testValue = 1300.4f;
        Mockito.when(bun.getPrice()).thenReturn(testValue);
        Burger burger = new Burger();
        burger.setBuns(bun);
        float result = burger.bun.getPrice();
        assertEquals(testValue, result, 0);
    }

    @Test
    public void addIngredientTest(){
        Burger burger = new Burger();
        Ingredient ingredient1 = new Ingredient(IngredientType.SAUCE, "соусхуёус", 1.333f);
        Ingredient ingredient2 = new Ingredient(IngredientType.FILLING, "соусхуёcxcxус", 1.333f);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        System.out.println(burger.ingredients.size());
    }
}
