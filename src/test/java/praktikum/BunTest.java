package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BunTest {
    private static final String nameBun = "Black";
    private static final float priceBun = 7.99F;
    private Bun bun;

    @Before
    //создаем булочку
    public void createNewBun(){
        bun = new Bun(nameBun, priceBun);
    }

    @Test
    //проверяем метод getName
    public void checkGetName() {
        assertEquals(nameBun, bun.getName());
    }

    @Test
    //проверяем метод getPrice
    public void checkGetPrice(){
        assertEquals(priceBun, bun.getPrice(), 0);
    }



}
