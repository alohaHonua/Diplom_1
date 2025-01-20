import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunExceptionTest {

    @Test(expected = NullPointerException.class)
    public void testBunCreationWithNullName() {
        new Bun(null, 100);
    }

    @Test
    public void testBunCreationWithNegativePrice() {
        Bun bun = new Bun("black bun", -100);
        assertEquals("black bun", bun.getName());
    }
}

