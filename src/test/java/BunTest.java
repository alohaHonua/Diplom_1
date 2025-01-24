import org.junit.Test;
import praktikum.Bun;

import static Constants.Constants.*;
import static org.junit.Assert.assertEquals;

public class BunTest {

    private final Bun bun = new Bun(NAME_BUN, PRICE_BUN);

    @Test
    public void getNameTest() {
         assertEquals(NAME_BUN, bun.getName());
    }

    @Test
    public void getPriceTest() {
        assertEquals(PRICE_BUN, bun.getPrice(), 0);
    }

}
