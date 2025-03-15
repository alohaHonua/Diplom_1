package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BunTests {

    @Test
    public void checkBunGetName() {
        String bunName = "Bulka";
        Bun bun = new Bun(bunName, 5);
        Assert.assertEquals(bunName, bun.getName());
    }

    @Test
    public void checkBunGetPrice() {
        float bunPrice = 5.6F;
        Bun bun = new Bun("Bulka2", bunPrice);
        Assert.assertEquals(bunPrice, bun.getPrice(), 0F);
    }
}