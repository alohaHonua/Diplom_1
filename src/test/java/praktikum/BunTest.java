package praktikum;

import org.junit.Assert;
import org.junit.Test;


public class BunTest {

    @Test
    public void getNameTest() {
        Bun bun = new Bun("black bun", 100);
        Assert.assertEquals("Unexpected name", bun.name, bun.getName());
    }

    @Test
    public void getPriceTest() {
        Bun bun = new Bun("white bun", 200);
        Assert.assertEquals("Unexpected price", bun.price, bun.getPrice(), 0);
    }
}
