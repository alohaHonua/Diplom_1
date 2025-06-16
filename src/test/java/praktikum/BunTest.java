package praktikum;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BunTest {

    @Test
    public void testBunProperties() {
        Bun bun = new Bun("Test Bun", 150.5f);
        assertEquals("Test Bun", bun.getName());
        assertEquals(150.5f, bun.getPrice());
    }
}
