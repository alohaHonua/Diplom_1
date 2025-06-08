package praktikum;

import org.junit.Test;
import static org.junit.Assert.*;
import praktikum.Bun;

public class BunTest {

    @Test
    public void testGetName() {
        Bun bun = new Bun("Anyname", 99.99f);
        assertEquals("Anyname", bun.getName());
    }

    @Test
    public void testGetPrice() {
        float price = 123.45f;
        Bun bun = new Bun("Simple", price);
        assertEquals(price, bun.getPrice(), 0.0f);
    }
}
