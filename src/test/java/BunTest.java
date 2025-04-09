import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.*;

public class BunTest {

    @Test
    public void testGetName() {
        Bun bun = new Bun("Sesame", 100);
        assertEquals("Sesame", bun.getName());
    }

    @Test
    public void testGetPrice() {
        Bun bun = new Bun("Rye", 120);
        assertEquals(120, bun.getPrice(), 0);
    }
}
