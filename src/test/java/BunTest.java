import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {

    private final String name = "Флюоресцентная булка R2-D3";
    private final float price = 988.0F;

    @Test
    public void getNameSuccess() throws Exception {
        Bun bun = new Bun(name, price);
        Assert.assertEquals(name, bun.getName());
    }

    @Test
    public void getPriceSuccess() throws Exception {
        Bun bun = new Bun(name, price);
        Assert.assertEquals(price, bun.getPrice(), 0.0F);
    }
}
