import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;


public class BunTests {

    String name = "bun";

    @Test
    public void testBunCreation() {
        float price = 0.0005F;

        Bun bun = new Bun(name, price);

        Assert.assertNotNull(bun);
        Assert.assertEquals(name, bun.getName());
        Assert.assertEquals(price, bun.getPrice(), 0.0001f);
    }

    @Test
    public void testGetName() {
        Bun bun = new Bun(name, 0.2F);

        String actualName = bun.getName();

        Assert.assertEquals(name, actualName);
    }

    @Test
    public void testGetPrice() {
        float price = 0.1F;
        Bun bun = new Bun("white bun", price);

        float actualPrice = bun.getPrice();

        Assert.assertEquals(0.01, actualPrice, 0.1);
    }
}
