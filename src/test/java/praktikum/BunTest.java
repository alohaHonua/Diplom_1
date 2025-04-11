package praktikum;

import junit.framework.TestCase;
import org.junit.Test;

public class BunTest extends TestCase {

    private static final String NAME = "Black bun";
    private static final float PRICE = 10f;
    private static final Bun BUN = new Bun(NAME, PRICE);

    @Test
    public void testGetName() {
        assertEquals(NAME, BUN.getName());
    }

    @Test
    public void testGetPrice() {
        assertEquals(PRICE, BUN.getPrice());
    }
}