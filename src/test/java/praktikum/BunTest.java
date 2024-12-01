package praktikum;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class  BunTest {
    private final String name = "Poppy bun";
    private final float price = 5.55f;
    private final Bun bun = new Bun(name, price);

    @Test
    public void getNameTest() {
        assertEquals(name, bun.getName());
    }

    @Test
    public void getPriceTest() {
        assertEquals(price, bun.getPrice(), 0);
    }
}
