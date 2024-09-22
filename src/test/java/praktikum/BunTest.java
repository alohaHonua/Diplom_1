package praktikum;

import parameters.Constants;
import org.junit.Assert;
import org.junit.Test;


public class BunTest {
    Bun bun = new Bun(Constants.BUN_NAME,Constants.BUN_PRICE);

    @Test
    public void getNameTest() {
        Assert.assertEquals(bun.getName(),Constants.BUN_NAME);
    }

    @Test
    public void getPrice() {
        Assert.assertEquals(bun.getPrice(),Constants.BUN_PRICE, Constants.BUN_PRICE_DELTA);
    }

}