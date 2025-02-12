import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import praktikum.Bun;

public class BunTest {
    private String name;
    private float price;
    private Bun bun;

    @Before
    public void init() {
        bun = new Bun("Флюоресцентная булка R2-D3", Float.valueOf(998));
    }

    @Test
    public void getNameBunTest() {
        Assert.assertEquals("Флюоресцентная булка R2-D3", bun.getName());
    }

    @Test
    public void getPriceBunTest() {
        Assert.assertEquals(Float.valueOf(998), bun.getPrice(),0);
    }
}

