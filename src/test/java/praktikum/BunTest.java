package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BunTest {

    Bun bun;

    @Before
    public void setUp() {
        bun = new Bun(Names.BUN_NAME, Price.BUN_PRICE);
    }

    @Test
    public void getNameCheckNameIsCorrect() {
        assertEquals(Names.BUN_NAME, bun.getName());
    }

    @Test
    public void getPriceCheckPriceIsCorrect() {
        assertEquals(Price.BUN_PRICE, bun.getPrice(), 0);
    }
}