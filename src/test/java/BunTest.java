import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {

    String name = "black bun";
    float price = 100;


    @Test
    public void getNameTest() {
        Bun bun = new Bun(name, price);
        String actual = bun.getName();
        Assert.assertEquals("black bun", actual);
    }

    @Test
    public void getPriceTest() {
        Bun bun = new Bun(name, price);
        float actual = bun.getPrice();
        Assert.assertEquals(100, actual,0);
    }
}

