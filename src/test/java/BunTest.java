import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {
    private final String bunName = "Bun name";
    private final float bunPrice = 12;
    Bun bun = new Bun(bunName, bunPrice);

    @Test
    public void getNameTest() {
        Assert.assertEquals(bun.getName(), bunName);
    }

    @Test
    public void getPriceTest() {
        Assert.assertEquals(bun.getPrice(), bunPrice, 0);
    }
}
