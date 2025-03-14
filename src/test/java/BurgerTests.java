import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTests {
/*    public static void main(String[] args){
        Bun bun = new Bun("qwerty", 3.14f);
        Burger burger = new Burger();
        burger.setBuns(bun);
        System.out.println(burger.bun.price);
        System.out.println(burger.bun.name);
    } */

    @Mock
    private Bun bun;

///////Этим тестом я проверяю корректную работу метода setBuns в классе Burger
    @Test
    public void setBunTestReturnName() {
        String testValue = "Название булочки";
        Mockito.when(bun.getName()).thenReturn(testValue);
        Burger burger = new Burger();
        burger.setBuns(bun);
        String result = burger.bun.getName();
        assertEquals(testValue, result);
    }

///////Этим тестом я проверяю корректную работу метода setBuns в классе Burger
    @Test
    public void setBunTestReturnPrice(){
        float testValue = 1300.4f;
        Mockito.when(bun.getPrice()).thenReturn(testValue);
        Burger burger = new Burger();
        burger.setBuns(bun);
        float result = burger.bun.getPrice();
        assertEquals(testValue, result, 0);
    }
}
