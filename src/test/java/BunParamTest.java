import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static praktikum.Constants.*;

@RunWith(Parameterized.class)
public class BunParamTest {
    private final String name;
    private final float price;

    public BunParamTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {FLU_BUN, PRICE_FLU_BUN},
                {KRATOR_BUN, PRICE_KRATOR_BUN}
        };
    }
    @Test
    public void getNameParamTest() {
        Bun bun = new Bun(name, price);
        Assert.assertEquals(name, bun.getName());
    }

    @Test
    public void getPriceParamTest() {
        Bun bun = new Bun(name, price);
        Assert.assertEquals(price, bun.getPrice(), 0);
    }
}
