import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {

    private final String BunName = "Бриошь";
    private final float BunPrice = 0.7777778F;

    @Test
    public void getNameTest() {
        Bun bun = new Bun(BunName, BunPrice);
        Assert.assertEquals(BunName, bun.getName());
    }

    @Test
    public void getPriceTest() {
        Bun bun = new Bun(BunName, BunPrice);
        Assert.assertEquals(BunPrice, bun.getPrice(), 0);
    }
}
