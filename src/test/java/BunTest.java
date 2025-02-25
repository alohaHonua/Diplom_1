import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import data.Names;
import data.Prices;

import static org.junit.Assert.assertEquals;

public class BunTest {
    Bun bun;

    @Before
    public void setUp() {
        bun = new Bun(Names.BUN_NAME, Prices.BUN_PRICE);
    }

    @Test
    public void getNameCheckThatNameIsCorrect() {
        assertEquals(Names.BUN_NAME, bun.getName());
    }

    @Test
    public void getPriceCheckThatPriceIsCorrect() {
        assertEquals(Prices.BUN_PRICE, bun.getPrice(), 0);
    }
}