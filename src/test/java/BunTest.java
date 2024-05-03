import org.junit.Test;
import static org.junit.Assert.*;
import praktikum.Bun;

public class BunTest {
    Bun bun = new Bun("Sesame Bun", 2.00f);

    @Test
    public void testGetName() {
        assertEquals("Sesame Bun", bun.getName());
    }

    @Test
    public void testGetPrice() {
        assertEquals(2.00f, bun.getPrice(), 0.01f);
    }

}
