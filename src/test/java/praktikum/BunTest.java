package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
public class BunTest {

    private static final String BUN_NAME = "Сладкая булочка";
    private static final float BUN_PRICE = 99999999999.9f;
    private static final float DELTA = 0.001f;

    private Bun bun;

    @Before
    public void setUp() {
        bun = new Bun(BUN_NAME, BUN_PRICE);
    }

    @Test
    public void testGetName() {
        assertEquals(BUN_NAME, bun.getName());
    }

    @Test
    public void testGetPrice() {
        assertEquals(BUN_PRICE, bun.getPrice(), DELTA);
    }
}
