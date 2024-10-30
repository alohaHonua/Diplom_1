import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {
    private Bun bun;

    @Before
    public void setUp() {
        bun = new Bun("black bun", 1.5f);
    }

    @Test
    public void testGetName() {
        assertEquals("black bun", bun.getName());
    }

    @Test
    public void testGetPrice() {
        assertEquals(1.5f, bun.getPrice(), 0.0f);
    }
}
