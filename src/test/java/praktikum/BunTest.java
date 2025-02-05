package praktikum;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BunTest {

    private Bun bun;

    @Before
    public void setUp() {
        bun = new Bun("Test Bun", 50.0f);
    }

    @Test
    public void testConstructor() {
        Bun testBun = new Bun("Classic", 30.0f);
        assertEquals("Classic", testBun.getName());
        assertEquals(30.0f, testBun.getPrice(), 0.001f);
    }

    @Test
    public void testGetName() {
        assertEquals("Test Bun", bun.getName());
    }

    @Test
    public void testGetPrice() {
        assertEquals(50.0f, bun.getPrice(), 0.001f);
    }

    @Test
    public void testEmptyConstructor() {
        Bun emptyBun = new Bun("", 0.0f);
        assertEquals("", emptyBun.getName());
        assertEquals(0.0f, emptyBun.getPrice(), 0.001f);
    }
}