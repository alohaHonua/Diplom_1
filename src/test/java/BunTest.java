import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {

    private final String name = "name";

    private float price = 50.00f;

    Bun bun;

    @Before
    public void setUp () {
        bun = new Bun(name, price);
    }
    @Test
    public void getNameReturnsSameName() {
        Assert.assertEquals(bun.getName(), name);
    }

    @Test
    public void getPriceReturnsSamePrice() {
        Assert.assertEquals(bun.getPrice(), 50.00f, 0.001);
    }
}

