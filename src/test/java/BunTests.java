import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTests {
    private final String NAME = "Флюоресцентная булка R2-D3";
    private final float PRICE = 988.01f;

    @Test
    public void getNameReturnsBunName() {
        Bun bun = new Bun(NAME, PRICE);
        Assert.assertEquals(NAME, bun.getName());
    }

    @Test
    public void getPriceReturnsBunPrice() {
        Bun bun = new Bun(NAME, PRICE);
        Assert.assertEquals(PRICE, bun.getPrice(), 0.001f);
    }
}
