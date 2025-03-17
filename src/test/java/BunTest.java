import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.*;

/**
 * Unit tests for the Bun class.
 */
public class BunTest {

    @Test
    public void testGetName() {
        Bun bun = new Bun("black bun", 100);
        assertEquals("black bun", bun.getName());
    }

    @Test
    public void testGetPrice() {
        Bun bun = new Bun("black bun", 100);
        assertEquals(100, bun.getPrice(), 0.01);
    }
}