import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;


public class BunTest {
    @Test
    public void getNameTest() {
        Bun bun = new Bun("Test", 1.2F);
        String expected = "Test";
        String actual = bun.getName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getPriceTest() {
        Bun bun = new Bun("Test", 1.2F);
        float expected = 1.2F;
        float actual = bun.getPrice();
        Assert.assertEquals(expected, actual, 0);
    }
}
