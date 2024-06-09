import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunsTest {

    @Test
    public void testToGetName() {
        Bun bun = new Bun("black bun", 100);
        assertEquals("black bun", bun.getName());
    }

    @Test
    public void tesTotGetPrice() {
        Bun bun = new Bun("white bun", 100);
        assertEquals(100, bun.getPrice(), 0.001);
    }
}