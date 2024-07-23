import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;

public class BunTest {

    private String BunName = "Бриошь";
    private float BunPrice = 0.7777778F;

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
