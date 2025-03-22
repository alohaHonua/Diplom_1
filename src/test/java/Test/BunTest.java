package Test;

import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.*;

public class BunTest {
    private Bun bun;

    @Before
    public void setUp() {
        bun = new Bun("Sesame", 2.5f);
    }

    @Test
    public void testGetName() {
        assertEquals("Sesame", bun.getName());
    }

    @Test
    public void testGetPrice() {
        assertEquals(2.5f, bun.getPrice(), 0.001);
    }
}
