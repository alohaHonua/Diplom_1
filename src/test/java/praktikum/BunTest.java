package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {

    @Test
    public void testGetName() {
        Bun bun = new Bun("Sesame", 50.0f);
        assertEquals("Sesame", bun.getName());
    }

    @Test
    public void testGetPrice() {
        Bun bun = new Bun("Sesame", 50.0f);
        assertEquals(50.0f, bun.getPrice(), 0.01f);
    }
}