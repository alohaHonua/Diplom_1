import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {
    private String name;
    private float price;

    @Test
    public void checkGetBunName() {
        Bun bun = new Bun("black bun", 100);

        String expectedName = "black bun";
        String actualName = bun.getName();

        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void checkGetBunPrice() {
        Bun bun = new Bun ("black bun", 100);

        float expectedPrice = 100;
        float actualPrice = bun.getPrice();

        Assert.assertEquals(expectedPrice,actualPrice, 0);

    }
}
