package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class BunTest {

    @Test
    public void getNameSuccess() throws Exception {
        Bun bun = new Bun("Флюоресцентная булка R2-D3", 988.0F);
        Assert.assertEquals("Флюоресцентная булка R2-D3", bun.getName());
    }

    @Test
    public void getPriceSuccess() throws Exception {
        Bun bun = new Bun("Краторная булка N-200i", 1255.0F);
        Assert.assertEquals(1255.0F, bun.getPrice(), 0.0F);
    }
}
