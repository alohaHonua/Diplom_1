package praktikum;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Тесты для класса Bun (булочка для бургера).
 */
public class BunTest {

    @Test
    public void testGetNameBlackBun() {
        Bun bun = new Bun("black bun", 100);
        assertEquals("black bun", bun.getName());
    }

    @Test
    public void testGetPriceBlackBun() {
        Bun bun = new Bun("black bun", 100);
        assertEquals(100, bun.getPrice(), 0);
    }

    @Test
    public void testGetNameWhiteBun() {
        Bun bun = new Bun("white bun", 200);
        assertEquals("white bun", bun.getName());
    }

    @Test
    public void testGetPriceWhiteBun() {
        Bun bun = new Bun("white bun", 200);
        assertEquals(200, bun.getPrice(), 0);
    }

    @Test
    public void testGetNameRedBun() {
        Bun bun = new Bun("red bun", 300);
        assertEquals("red bun", bun.getName());
    }

    @Test
    public void testGetPriceRedBun() {
        Bun bun = new Bun("red bun", 300);
        assertEquals(300, bun.getPrice(), 0);
    }
}
