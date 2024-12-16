package praktikum;

import static constants.Constants.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class BunTest {

    private Bun bun;

    @Before
    public void setUp() {
        bun = new Bun(BUN_NAME, BUN_PRICE);
    }

    @Test
    public void testBunCreation() {
        assertNotNull(bun);
    }

    @Test
    public void testGetName() {
        String name = bun.getName();
        assertEquals(BUN_NAME, name);
    }

    @Test
    public void testGetPrice() {
        float price = bun.getPrice();
        assertEquals(BUN_PRICE, price, DELTA);
    }
}