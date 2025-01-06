import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {
    private String bunName = "Sesame bun";
    private float bunPrice = 100.5f;

    @Test
    public void getNameTest() {
        Bun bun = new Bun(bunName, bunPrice);
        Assert.assertEquals(bunName, bun.getName());
    }

    @Test
    public void getPriceTest() {
        float delta = 0.01f;
        Bun bun = new Bun(bunName, bunPrice);
        Assert.assertEquals(bunPrice, bun.getPrice(), delta);
    }
}
