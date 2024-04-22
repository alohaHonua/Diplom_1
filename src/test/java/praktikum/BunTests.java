package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BunTests {
    private final String name = "Sinna bun";
    private final float price = 100;
    private Bun newBun;

    @Before
    public void newBun() {
        newBun = new Bun(name, price);
    }

    @Test
    public void getNameTest() {
        String result = newBun.getName();
        Assert.assertEquals(name, result);
    }

    @Test
    public void getPriceTest() {
        float result = newBun.getPrice();
        Assert.assertEquals(price, result, 0);
    }
}
