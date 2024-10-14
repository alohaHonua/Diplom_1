import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {

    private static final String BUN_NAME = "black bun";
    private static final float BUN_PRICE = 1.9f;
    private static final float DELTA = 0000.1f;

    private Bun bun;

    @Before
    public void setUp() {
        bun = new Bun(BUN_NAME, BUN_PRICE);
    }

    @Test
    public void getNameTest() {
        String actual = bun.getName();
        Assert.assertEquals(BUN_NAME, actual);
    }

    @Test
    public void getPriceTest() {
        float actual = bun.getPrice();
        Assert.assertEquals(BUN_PRICE, actual, DELTA);
    }
}
