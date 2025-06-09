package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BunTest {
    Bun bun;

    @Before
    public void setUp(){
        bun = new Bun("black bun", 100);
    }

    @Test
    public void getNameTest() {
        assertEquals("Название булочки должно соответствовать 'black bun'", "black bun", bun.getName());
    }

    @Test
    public void getPriceTest() {
        assertEquals("Цена булочки должна соответствовать '100'", 100, bun.getPrice(), 0);
    }
}