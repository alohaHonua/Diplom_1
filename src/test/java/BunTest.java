import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {

    private Bun bun;

    @Before
    public void setUp() {
        bun = new Bun(Credentials.BUN_NAME, Credentials.BUN_PRICE);
    }

    @Test
    public void getNameTest() {
        String actual = bun.getName();
        Assert.assertEquals(Credentials.BUN_NAME, actual);
    }

    @Test
    public void getPriceTest() {
        float actual = bun.getPrice();
        Assert.assertEquals(Credentials.BUN_PRICE, actual, Credentials.DELTA);
    }
}
