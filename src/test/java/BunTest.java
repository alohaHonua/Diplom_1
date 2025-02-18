import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import praktikum.Bun;

public class BunTest {
    private static final String BUN_NAME = "Флюоресцентная булка R2-D3";
    private static final float BUN_PRICE = 988;

    private Bun bun;

    @Before
    public void init() {
        bun = new Bun(BUN_NAME, Float.valueOf(BUN_PRICE));
    }

    @Test
    public void getNameBunTest() {
        Assert.assertEquals("Наименование булки возвращается не верно"
                , BUN_NAME, bun.getName());
    }

    @Test
    public void getPriceBunTest() {
        Assert.assertEquals("Цена булки возвращается не верно"
                , Float.valueOf(BUN_PRICE), bun.getPrice(),0);
    }
}

