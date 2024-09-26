import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BunTest {
    @Test
    public void testGetName() {
        Bun bun = new Bun("Sesame", 1.50f);
        assertEquals("Sesame", bun.getName());
    }

    @Test
    public void testGetPrice() {
        Bun bun = new Bun("Sesame", 1.50f);
        assertEquals(1.50f, bun.getPrice(), 0.01);
    }
}
