package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class BunClassTests {
    private final String name = "TestBan";
    private final float price = 5;

    Bun bun = new Bun(name, price);

    @Test
    public void testGetName() {
        Assert.assertEquals(name, bun.getName());
    }

    @Test
    public void testGetPrice() {
        Assert.assertEquals(price, bun.getPrice(), 0.0);
    }
}
