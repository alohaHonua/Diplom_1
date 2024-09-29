import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {

    @Test
    public void testGetName() {
        Bun bun = new Bun("white bun", 200);
        assertEquals("white bun", bun.getName());
    }

    @Test
    public void testGetPrice() {
        Bun bun = new Bun("white bun", 200);
        assertEquals(200, bun.getPrice(), 0.0f);
    }
}
