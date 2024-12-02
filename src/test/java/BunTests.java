import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import service.TestConstants;

public class BunTests {
    private static final String NAME = "Флюоресцентная булка R2-D3";
    private static final float PRICE = 988.01f;
    private Bun bun;

    @Before
    public void initBun() {
        bun = new Bun(NAME, PRICE);
    }

    @Test
    public void getNameReturnsBunName() {
        Assert.assertEquals(NAME, bun.getName());
    }

    @Test
    public void getPriceReturnsBunPrice() {
        Assert.assertEquals(PRICE, bun.getPrice(), TestConstants.DELTA);
    }
}
