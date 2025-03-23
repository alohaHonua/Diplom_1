import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;
import static praktikum.Const.*;

public class BunTests {

    @Test
    public void bunGetName() {
        Bun bun = new Bun (BUN_NAME, BUN_PRICE);
        assertEquals(BUN_NAME, bun.getName());
    }

    @Test
    public void bunGetPrice() {
        Bun bun = new Bun (BUN_NAME, BUN_PRICE);
        assertEquals(BUN_PRICE, bun.getPrice(), DELTA);
    }
}
