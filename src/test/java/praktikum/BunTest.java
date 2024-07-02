package praktikum;

import org.junit.Test;
import static org.junit.Assert.*;
public class BunTest {


    @Test
    public void testGetName() {
        Bun bun = new Bun("black bun", 100);
        String expected = "black bun";
        String actual = bun.getName();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetPrice() {
        Bun bun = new Bun("black bun", 100);
        float expected = 100;
        float actual = bun.getPrice();
        assertEquals(expected, actual, 0);
    }
}
