package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class BunTest {

    private static final String bunNameTest = "Тестовая булочка";
    private static final float bunPriceTest = 10.00F;

    @Test
    public void getNameTest() {
        Bun bun = new Bun(bunNameTest, (float) bunPriceTest);

        Assert.assertEquals(bunNameTest, bun.getName());
    }

    @Test
    public void getPriceTest() {
        Bun bun = new Bun(bunNameTest, bunPriceTest);

        Assert.assertEquals(bunPriceTest, bun.getPrice(), 0.0F);
    }
}