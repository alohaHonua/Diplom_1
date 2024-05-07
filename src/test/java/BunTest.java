import org.junit.Test;
import praktikum.Bun;
import static org.junit.Assert.assertEquals;

public class BunTest {
    @Test
    public void testConstructor() {
        Bun bun = new Bun("Brioche", 1.5f);
        assertEquals("Brioche", bun.getName());
        assertEquals(1.5f, bun.getPrice(), 0.001);
    }

    @Test
    public void testGetName() {
        Bun bun = new Bun("Sesame", 1.0f);
        assertEquals("Sesame", bun.getName());
    }

    @Test
    public void testGetPrice() {
        Bun bun = new Bun("Whole Grain", 2.0f);
        assertEquals(2.0f, bun.getPrice(), 0.001);
    }
}
