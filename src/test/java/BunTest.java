import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunTest {
    private final String name;
    private final float price;
    private final static double DELTA = 0.00;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] BunTestData() {
        return new Object[][] {
                {"Флюоресцентная булка R2-D3", 988},
                {"Краторная булка N-200i", 1255},
        };
    }

    @Test
    public void getNameTest() {
        Bun bun = new Bun(name, price);
        Assert.assertEquals(name,bun.getName());
    }

    @Test
    public void getPriceTest() {
        Bun bun = new Bun(name, price);
        Assert.assertEquals(price, bun.getPrice(), DELTA);
    }
}
