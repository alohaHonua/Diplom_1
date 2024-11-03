import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {
    Bun bun = new Bun(Config.BUN_NAME, Config.BUN_PRICE);

    @Test
    public void getNameTest() {
        Assert.assertEquals(Config.BUN_NAME, bun.getName());
    }
    @Test
    public void getPriceTest() {
        Assert.assertEquals(Config.BUN_PRICE, bun.getPrice(), Config.DEF_ASSERT_DELTA);
    }
}
