package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {
    private static final String TEST_BUN_NAME = "Black bun";
    private static final float TEST_PRICE = 10;

    @Test
    public void getNameTest() {
        Bun bun = new Bun(TEST_BUN_NAME, TEST_PRICE);
        assertEquals(TEST_BUN_NAME, bun.getName());
    }

    @Test
    public void getPriceTest() {
        Bun bun = new Bun(TEST_BUN_NAME, TEST_PRICE);
        assertEquals(TEST_PRICE, bun.getPrice(), 0.0f);
    }
}