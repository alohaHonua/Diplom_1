import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Burger;

import static org.junit.Assert.assertTrue;

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

    @Before
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }
///////Этим тестом я проверяю корректную работу метода setBuns в классе Burger
    @Test
    public void setBunTest() {
        Mockito.when(bun.getName()).thenReturn("Название булочки");
        Burger burger = new Burger();
        burger.setBuns(bun);
        String result = burger.bun.getName();
        assertTrue("Результат не является строкой", result instanceof String);
    }
}
