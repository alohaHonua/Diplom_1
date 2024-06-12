import praktikum.Bun;
import org.junit.Test;
import org.junit.Assert;

public class BunTest {
    private final String name = "black bun";
    private final Float price = 100F;
    private final Bun bun = new Bun(name, price);

    @Test
    public void getNameReturnName() {
        Assert.assertEquals(name, bun.getName());
    }

    @Test
    public void getPriceReturnPrice() {
        Assert.assertEquals(price, bun.getPrice(), 0.0f);
    }
}
