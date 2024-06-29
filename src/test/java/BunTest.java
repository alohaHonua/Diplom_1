import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import praktikum.Bun;

public class BunTest {
    private Bun bun;

    @Before
    public void setUp() {
        bun = new Bun("Classic Bun", 5.5f);
    }

    @Test
    public void testGetName() {
        assertEquals("Classic Bun", bun.getName());
    }

    @Test
    public void testGetPrice() {
        assertEquals(5.5f, bun.getPrice(), 0.01);
    }
}
