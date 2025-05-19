package praktikum;

import org.junit.Test;
import static org.junit.Assert.*;

public class BunTest {

    @Test
    public void getNameReturnsCorrectName() {
        Bun bun = new Bun("Black bun", 100);
        assertEquals("Black bun", bun.getName());
    }

    @Test
    public void getPriceReturnsCorrectPrice() {
        Bun bun = new Bun("Black bun", 100);
        assertEquals(100, bun.getPrice(), 0);
    }
}
