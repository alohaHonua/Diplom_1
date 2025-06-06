package praktikum;

import org.junit.Test;
import static org.junit.Assert.*;

public class BunTest {

    @Test
    public void bunReturnsCorrectName() {
        Bun bun = new Bun("Test Bun", 123.45f);
        assertEquals("Test Bun", bun.getName());
    }

    @Test
    public void bunReturnsCorrectPrice() {
        Bun bun = new Bun("Test Bun", 123.45f);
        assertEquals(123.45f, bun.getPrice(), 0.01f);
    }
}
