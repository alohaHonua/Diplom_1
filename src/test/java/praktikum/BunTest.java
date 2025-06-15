package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class BunTest {
    private final String name = "бургер";
    private final float price = 4.8f;
    Bun bun = new Bun(name, price);

    @Test
    public void testGetName() {
        Assert.assertEquals(name, bun.getName());
    }

    @Test
    public void testGetPrice() {
        Assert.assertEquals(price, bun.getPrice(), 0.0001f);
    }
}